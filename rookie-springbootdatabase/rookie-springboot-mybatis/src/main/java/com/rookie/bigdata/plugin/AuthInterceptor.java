//package com.rookie.bigdata.plugin;
//
//import com.rookie.bigdata.common.enums.AuthFilter;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.binding.MapperMethod;
//import org.apache.ibatis.cache.CacheKey;
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.mapping.BoundSql;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Signature;
//import org.apache.ibatis.session.ResultHandler;
//import org.apache.ibatis.session.RowBounds;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//import java.util.*;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * @Class AuthInterceptor
// * @Description https://www.jb51.net/program/3301264pt.htm
// * @Author rookie
// * @Date 2024/11/13 16:25
// * @Version 1.0
// */
//@Slf4j
////@Component
//@Intercepts({@Signature(
//        type = Executor.class,
//        method = "query",
//        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
//), @Signature(
//        type = Executor.class,
//        method = "query",
//        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}
//)})
//public class AuthInterceptor implements Interceptor {
//
//    private static final Map<Class<?>, Map<String, List<List<Class>>>> mapperCache = new ConcurrentHashMap();
//
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//
//        Object[] args = invocation.getArgs();
//        String id = ((MappedStatement) args[0]).getId();
//        String clazzName = id.substring(0, id.lastIndexOf('.'));
//        String mapperMethod = id.substring(id.lastIndexOf('.') + 1);
//
//        Object[] paramArr = getParamArr(args[1]);
//        Class<?> clazz = Class.forName(clazzName);
//
//        Method method = getMethod(clazz, mapperMethod, paramArr);
//        AuthFilter authFilter = method.getAnnotation(AuthFilter.class);
//
//
//        // 如果方法没有加上注解正常执行 ，否则开始解析
//        if (authFilter != null) {
//
//            Map params = new HashMap();
//            // 获取各个filed
//            String orgFiled = authFilter.orgFiled();
//            String userFiled = authFilter.userFiled();
//            // 获取用户登录id 和 组织Id
//            String orgId = GlobalHolder.getOrgId();
//            String loginId = GlobalHolder.getLoginId();
//
//            boolean ignoreOrgFiled = authFilter.ignoreOrgFiled();
//            boolean ignoreUserFiled = authFilter.ignoreUserFiled();
//
//            MappedStatement ms = (MappedStatement) args[0];
//            Object parameter = args[1];
//            BoundSql boundSql;
//            if (args.length == 4) {
//                boundSql = ms.getBoundSql(parameter);
//            } else {
//                boundSql = (BoundSql) args[5];
//            }
//
//            String sql = boundSql.getSql();
//
//            // 添加组织编号
//            if (!ignoreOrgFiled) {
//
//                if (StringUtils.isNotEmpty(orgId)) {
//                    params.put(orgFiled, orgId);
//                } else {
//                    throw new IllegalStateException("用户未登录！");
//                }
//
//            }
//
//            if (!ignoreUserFiled) {
//
//                if (StringUtils.isNotEmpty(loginId)) {
//                    params.put(userFiled, loginId);
//                } else {
//                    throw new IllegalStateException("用户未登录！");
//                }
//            }
//
//            if (params.size() > 0) {
//                String concatSql = contactConditions(wrapSql(sql), params);
//                log.info("添加后的sql为： {}", concatSql);
//                ReflectUtil.setFieldValue(boundSql, "sql", concatSql);
//            }
//        }
//        return invocation.proceed();
//    }
//
//
//    @Override
//    public Object plugin(Object target) {
//        return Plugin.wrap(target, this);
//
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//    }
//
//    private String wrapSql(String sql) {
//
//        if (StringUtils.isNotEmpty(sql)) {
//
//            StringBuilder realSql = new StringBuilder();
//            realSql.append("select * from ( ");
//            realSql.append(sql);
//            realSql.append(") a");
//
//            return realSql.toString();
//        }
//        return sql;
//    }
//
//    /**
//     * 获取 mapper 相应 Method 反射类
//     */
//    private Method getMethod(Class<?> clazz, String mapperMethod, Object[] paramArr) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
//        // 1、查 mapper 接口缓存
//        if (!mapperCache.containsKey(clazz)) // mapper 没有缓存, 就进行缓存
//        {
//            cacheMapper(clazz);
//        }
//        // 2、返回相应 method
//        A:
//        for (List<Class> paramList : mapperCache.get(clazz).get(mapperMethod)) {
//            if (!paramList.isEmpty()) {
//                for (int i = 0; i < paramArr.length; i++) { // 比较参数列表class
//                    if (paramArr[i] != null)
//                        if (!compareClass(paramList.get(i), paramArr[i].getClass())) continue A;
//                }
//                return clazz.getMethod(mapperMethod, paramList.toArray(new Class[paramList.size()]));
//            }
//        }
//        return clazz.getMethod(mapperMethod); // 返回无参方法
//    }
//
//    /**
//     * 对 mapper 方法字段进行缓存
//     */
//    private void cacheMapper(Class<?> clazz) {
//        Map<String, List<List<Class>>> methodMap = new HashMap();
//        for (Method method : clazz.getMethods()) {
//            List<List<Class>> paramLists = methodMap.containsKey(method.getName()) ?
//                    methodMap.get(method.getName()) : new ArrayList<List<Class>>();
//            List<Class> paramClass = new ArrayList<Class>();
//            for (Type type : method.getParameterTypes()) {
//                paramClass.add((Class) type);
//            }
//            paramLists.add(paramClass);
//            methodMap.put(method.getName(), paramLists);
//        }
//        mapperCache.put(clazz, methodMap);
//    }
//
//    /**
//     * class 比较
//     */
//    private boolean compareClass(Class<?> returnType, Class<?> paramType) throws NoSuchFieldException, IllegalAccessException {
//        if (returnType == paramType) {
//            return true;
//        } else if (returnType.isAssignableFrom(paramType)) { // 判断 paramType 是否为 returnType 子类或者实现类
//            return true;
//        }
//        // 基本数据类型判断
//        else if (returnType.isPrimitive()) { // paramType为包装类
//            return returnType == paramType.getField("TYPE").get(null);
//        } else if (paramType.isPrimitive()) { // returnType为包装类
//            return paramType == returnType.getField("TYPE").get(null);
//        }
//        return false;
//    }
//
//    /**
//     * 获取 mybatis 中 mapper 接口的参数列表的参数值
//     *
//     * @param parameter
//     * @return
//     */
//    private Object[] getParamArr(Object parameter) {
//        Object[] paramArr = null;
//        // mapper 接口中使用的是 paramMap, 传多个参数
//        if (parameter instanceof MapperMethod.ParamMap) {
//            Map map = ((Map) parameter);
//            if (!map.isEmpty()) {
//                StringBuilder builder = new StringBuilder();
//                // 初始化 param_arr
//                int size = map.size() >> 1;
//                paramArr = new Object[size];
//                for (int i = 1; i <= size; i++) {
//                    // mapper 接口中使用 param0 ~ paramN 命名参数
//                    paramArr[i - 1] = map.get(builder.append("param").append(i).toString());
//                    builder.setLength(0);
//                }
//            }
//        } else if (parameter != null) {
//            paramArr = new Object[1];
//            paramArr[0] = parameter;
//        }
//        return paramArr;
//    }
//
//
//    private static String contactConditions(String sql, Map<String, Object> columnMap) {
//        SQLStatementParser parser = SQLParserUtils.createSQLStatementParser(sql, JdbcUtils.MYSQL);
//        List<SQLStatement> stmtList = parser.parseStatementList();
//        SQLStatement stmt = stmtList.get(0);
//        if (stmt instanceof SQLSelectStatement) {
//            StringBuffer constraintsBuffer = new StringBuffer();
//            Set<String> keys = columnMap.keySet();
//            Iterator<String> keyIter = keys.iterator();
//            if (keyIter.hasNext()) {
//                String key = keyIter.next();
//                constraintsBuffer.append(key).append(" = " + getSqlByClass(columnMap.get(key)));
//            }
//            while (keyIter.hasNext()) {
//                String key = keyIter.next();
//                constraintsBuffer.append(" AND ").append(key).append(" = " + getSqlByClass(columnMap.get(key)));
//            }
//            SQLExprParser constraintsParser = SQLParserUtils.createExprParser(constraintsBuffer.toString(), JdbcUtils.MYSQL);
//            SQLExpr constraintsExpr = constraintsParser.expr();
//
//            SQLSelectStatement selectStmt = (SQLSelectStatement) stmt;
//            // 拿到SQLSelect
//            SQLSelect sqlselect = selectStmt.getSelect();
//            SQLSelectQueryBlock query = (SQLSelectQueryBlock) sqlselect.getQuery();
//            SQLExpr whereExpr = query.getWhere();
//            // 修改where表达式
//            if (whereExpr == null) {
//                query.setWhere(constraintsExpr);
//            } else {
//                SQLBinaryOpExpr newWhereExpr = new SQLBinaryOpExpr(whereExpr, SQLBinaryOperator.BooleanAnd, constraintsExpr);
//                query.setWhere(newWhereExpr);
//            }
//            sqlselect.setQuery(query);
//            return sqlselect.toString();
//
//        }
//
//        return sql;
//    }
//
//    private static String getSqlByClass(Object value) {
//
//        if (value instanceof Number) {
//            return value + "";
//        } else if (value instanceof String) {
//            return "'" + value + "'";
//        }
//
//        return "'" + value.toString() + "'";
//    }
//
//}
