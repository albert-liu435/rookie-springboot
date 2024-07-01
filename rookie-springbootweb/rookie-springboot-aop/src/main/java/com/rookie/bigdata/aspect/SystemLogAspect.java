//package com.rookie.bigdata.aspect;
//
//import org.aspectj.lang.JoinPoint;
//
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Class SystemLogAspect
// * @Description https://blog.csdn.net/weixin_43888891/article/details/122116930
//https://blog.csdn.net/weixin_43888891/article/details/122139409
// * @Author rookie
// * @Date 2024/7/1 17:54
// * @Version 1.0
// */
//@Aspect
//@Component
//@Slf4j
//public class SystemLogAspect {
//
//    private static final ThreadLocal<Date> beginTimeThreadLocal = new NamedThreadLocal<Date>("ThreadLocal beginTime");
//
//    @Autowired
//    private LogDao logDao;
//
//    @Autowired
//    private IpInfoUtil ipInfoUtil;
//
//    @Autowired(required = false)
//    private HttpServletRequest request;
//
//    /**
//     * Controller层切点,注解方式
//     */
//    //@Pointcut("execution(* *..controller..*Controller*.*(..))")
//    @Pointcut("@annotation(cn.org.xaas.equipment.annotation.SystemLog)")
//    public void controllerAspect() {
//
//    }
//
//    /**
//     * 前置通知 (在方法执行之前返回)用于拦截Controller层记录用户的操作的开始时间
//     *
//     * @param joinPoint 切点
//     * @throws InterruptedException
//     */
//    @Before("controllerAspect()")
//    public void doBefore(JoinPoint joinPoint) throws InterruptedException {
//
//        //线程绑定变量（该数据只有当前请求的线程可见）
//        Date beginTime = new Date();
//        beginTimeThreadLocal.set(beginTime);
//    }
//
//    /**
//     * 后置通知(在方法执行之后并返回数据) 用于拦截Controller层无异常的操作
//     *
//     * @param joinPoint 切点
//     */
//    @AfterReturning("controllerAspect()")
//    public void after(JoinPoint joinPoint) {
//        try {
//            // 获取操作人，每个系统不一样，一般存储与session，此处就不展示了
//            String username = HeaderSecurityUtils.getUserName();
//
//            // 读取json数据
//            String openApiRequestData = getJSON(request);
//            Map<String, String[]> requestParams = request.getParameterMap();
//
//            Log log = new Log();
//            if (openApiRequestData != null) {
//                log.setRequestJson(JSONUtil.toJsonStr(openApiRequestData));
//            }
//            log.setId(IdUtil.simpleUUID());
//            log.setUsername(username);
//            //日志标题
//            String description = getControllerMethodInfo(joinPoint).get("description").toString();
//            log.setDescription(description);
//            //日志类型
//            log.setOperationType((int) getControllerMethodInfo(joinPoint).get("type"));
//            //日志请求url
//            log.setRequestUrl(request.getRequestURI());
//            //请求方式
//            log.setRequestType(request.getMethod());
//            //请求参数
//            log.setRequestParam(JSONUtil.toJsonStr(requestParams));
//
//            //其他属性
//            log.setIp(ipInfoUtil.getIpAddr(request));
//            log.setCreateBy(username);
//            log.setUpdateBy(username);
//            log.setCreateTime(new Date());
//            log.setUpdateTime(new Date());
//            log.setDeleteFlag("0");
//
//            //请求开始时间
//            long beginTime = beginTimeThreadLocal.get().getTime();
//            long endTime = System.currentTimeMillis();
//            //请求耗时
//            Long logElapsedTime = endTime - beginTime;
//            log.setCostTime(logElapsedTime.intValue());
//
//            //持久化(存储到数据或者ES，可以考虑用线程池)
//            ThreadPoolUtil.getPool().execute(new SaveSystemLogThread(log, logDao));
//
//        } catch (Exception e) {
//            log.error("AOP后置通知异常", e);
//        }
//    }
//
//    /**
//     * 获取request的body
//     *
//     * @param request
//     * @return
//     */
//    public String getJSON(HttpServletRequest request) {
//        ServletInputStream inputStream = null;
//        InputStreamReader inputStreamReader = null;
//        BufferedReader streamReader = null;
//        StringBuilder responseStrBuilder = new StringBuilder();
//        try {
//            inputStream = request.getInputStream();
//            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
//            streamReader = new BufferedReader(inputStreamReader);
//            String inputStr;
//            while ((inputStr = streamReader.readLine()) != null) {
//                responseStrBuilder.append(inputStr);
//            }
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        } finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (inputStreamReader != null) {
//                    inputStreamReader.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (streamReader != null) {
//                    streamReader.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return responseStrBuilder.toString();
//    }
//
//    /**
//     * 保存日志至数据库
//     */
//    private static class SaveSystemLogThread implements Runnable {
//
//        private Log log;
//        private LogDao logDao;
//
//        public SaveSystemLogThread(Log esLog, LogDao logDao) {
//            this.log = esLog;
//            this.logDao = logDao;
//        }
//
//        @Override
//        public void run() {
//            logDao.insert(log);
//        }
//    }
//
//    /**
//     * 获取注解中对方法的描述信息 用于Controller层注解
//     *
//     * @param joinPoint 切点
//     * @return 方法描述
//     * @throws Exception
//     */
//    public static Map<String, Object> getControllerMethodInfo(JoinPoint joinPoint) throws Exception {
//
//        Map<String, Object> map = new HashMap<String, Object>(16);
//        //获取目标类名
//        String targetName = joinPoint.getTarget().getClass().getName();
//        //获取方法名
//        String methodName = joinPoint.getSignature().getName();
//        //获取相关参数
//        Object[] arguments = joinPoint.getArgs();
//        //生成类对象
//        Class targetClass = Class.forName(targetName);
//        //获取该类中的方法
//        Method[] methods = targetClass.getMethods();
//
//        String description = "";
//        Integer type = null;
//
//        for (Method method : methods) {
//            if (!method.getName().equals(methodName)) {
//                continue;
//            }
//            Class[] clazzs = method.getParameterTypes();
//            if (clazzs.length != arguments.length) {
//                //比较方法中参数个数与从切点中获取的参数个数是否相同，原因是方法可以重载哦
//                continue;
//            }
//            description = method.getAnnotation(SystemLog.class).description();
//            type = method.getAnnotation(SystemLog.class).type().ordinal();
//            map.put("description", description);
//            map.put("type", type);
//        }
//        return map;
//    }
//
//}
