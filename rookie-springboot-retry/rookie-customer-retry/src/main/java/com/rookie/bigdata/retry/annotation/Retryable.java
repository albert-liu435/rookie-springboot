package com.rookie.bigdata.retry.annotation;

import java.lang.annotation.*;

/**
 * @Class Retryable
 * @Description 注解用于方法上
 * @Author rookie
 * @Date 2024/1/2 13:55
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface Retryable {

    /***
     * 异常类型值
     * @return
     */
    Class<? extends Throwable>[] value() default {};

    /**
     * 最大重试次数，默认为3
     *
     * @return
     */
    int maxAttempts() default 3;

    /**
     * 是否为异步，默认为false
     *
     * @return
     */
    boolean async() default false;

}
