package com.rookie.bigdata.aspect;

import com.alibaba.fastjson2.JSONObject;
import com.google.common.util.concurrent.RateLimiter;
import com.rookie.bigdata.annotation.GuavaLimitRateAnnotation;
import com.rookie.bigdata.util.RateLimitHelper;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Class GuavaLimitRateAspect
 * @Description
 * @Author rookie
 * @Date 2024/8/19 16:06
 * @Version 1.0
 */
@Aspect
@Component
public class GuavaLimitRateAspect {

    private static Logger logger = LoggerFactory.getLogger(GuavaLimitRateAspect.class);

    @Before("execution(@GuavaLimitRateAnnotation * *(..))")
    public void limit(JoinPoint joinPoint) {
        // 1.获取当前方法
        Method currentMethod = getCurrentMethod(joinPoint);
        if (Objects.isNull(currentMethod)) {
            return;
        }
        // 2.从方法注解定义上获取限流的类型
        String limitType = currentMethod.getAnnotation(GuavaLimitRateAnnotation.class).limitType();
        double limitCount = currentMethod.getAnnotation(GuavaLimitRateAnnotation.class).limitCount();
        // 3.使用guava的令牌桶算法获取一个令牌，获取不到先等待
        RateLimiter rateLimiter = RateLimitHelper.getRateLimiter(limitType, limitCount);
        boolean b = rateLimiter.tryAcquire();
        if (b) {
            System.out.println("获取到令牌");
        } else {
            HttpServletResponse resp = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",false);
            jsonObject.put("msg","限流中");
            try {
                output(resp, jsonObject.toJSONString());
            } catch (Exception e) {
                logger.error("error,e:{}", e);
            }
        }
    }

    public void output(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(msg.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert outputStream != null;
            outputStream.flush();
            outputStream.close();
        }
    }

    private Method getCurrentMethod(JoinPoint joinPoint) {
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method target = null;
        for (Method method : methods) {
            if (method.getName().equals(joinPoint.getSignature().getName())) {
                target = method;
                break;
            }
        }
        return target;
    }

}
