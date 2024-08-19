package com.rookie.bigdata.aspect;

import com.alibaba.fastjson2.JSONObject;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import com.rookie.bigdata.annotation.Limit;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Class LimitAspect
 * @Description
 * @Author rookie
 * @Date 2024/8/19 15:52
 * @Version 1.0
 */
@Slf4j
@Aspect//定义为切面
@Component
public class LimitAspect {

    /**
     * 不同的接口，不同的流量控制，map的key为Limit.key
     */
    private final Map<String , RateLimiter> limiterMap = Maps.newConcurrentMap();

    @Around("@annotation(com.rookie.bigdata.annotation.Limit)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Limit limit = method.getAnnotation(Limit.class);//获取到方法上的Limit注解

        if(limit != null){
            RateLimiter rateLimiter = limiterMap.get(limit.key());
            if(null == rateLimiter){
                //创建当前key的RateLimiter
                rateLimiter = RateLimiter.create(limit.permitsPerSecond());
                limiterMap.put(limit.key(),rateLimiter);
                log.info("创建了新的令牌桶，key={},容量={}",limit.key(),limit.permitsPerSecond());
            }
            boolean success = rateLimiter.tryAcquire(0, limit.timeUnit());
            if(!success){
                log.info("获取令牌失败,key={}",limit.key());
                this.responseFail(limit.message());
                return null;
            }
            log.info("获取令牌成功,key={}",limit.key());

        }
        return joinPoint.proceed();
    }

    private void responseFail(String message) throws IOException {
        HttpServletResponse response=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        JSONObject object = new JSONObject();
        object.put("success",false);
        object.put("code",2001);
        object.put("message",message);
        pw.write(object.toJSONString());
        pw.flush();
        pw.close();
    }
}
