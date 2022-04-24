package com.rookie.bigdata.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LogAspect
 * @Description http://www.macrozheng.com/#/technology/aop_log
 * @Author rookie
 * @Date 2021/6/17 16:20
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspect {


    //@Pointcut("execution(* com.rookie.bigdata.controller..*.*(..)) || @annotation(com.rookie.bigdata.annotation.Log)")
    @Pointcut("execution(* com.rookie.bigdata.controller..*.*(..)) && @annotation(com.rookie.bigdata.annotation.Log)")
    public void webLog() {
    }

    /**
     * 前置通知
     *
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("前置通知");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        System.out.println(signature.getName());
        //AOP代理类的名字
        System.out.println(signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String, String> parameterMap = new HashMap<>();
        while (enumeration.hasMoreElements()) {
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter, request.getParameter(parameter));
        }
        System.out.println(parameterMap);
    }

    /**
     * 后置通知
     *
     * @param joinPoint
     */
    @After("webLog()")
    public void returnAfter(JoinPoint joinPoint) {
        System.out.println("后置通知");
    }

    /**
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "webLog()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("AOP afterRuturning:" + result);
    }

    /**
     * 异常抛出通知
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "webLog()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("AOP afterThrowing:" + ex);
    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @return
     */
    @Around(value = "webLog()")
    public Object aroundLogging(ProceedingJoinPoint joinPoint) {
        //可以记录执行时间，并将信息保存到数据库中
        Object result = null;
        try {
            long start=System.currentTimeMillis();
            System.out.println("around before");
            result = joinPoint.proceed();
            System.out.println("around return" + result);
            long betwwem=System.currentTimeMillis()-start;
        } catch (Throwable throwable) {
            System.out.println("around exception:" + throwable);
        }
        System.out.println("around after");
        return result;
    }
}
