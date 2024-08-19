package com.rookie.bigdata.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @Class Limit
 * @Description
 * @Author rookie
 * @Date 2024/8/19 15:50
 * @Version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)//修饰注解，用来表示注解的生命周期
@Target({ElementType.METHOD})//注解的作用目标，这个表示注解到方法
public @interface Limit {

    /**
     * 资源的key,唯一
     * 作用：不同的接口，不同的流量控制
     */
    String key() default "";

    /**
     * 限制次数（每秒）
     */
    double permitsPerSecond();

    /**
     * 最大等待时间
     */
    long timeOut();

    /**
     * 最大等待时间的单位，默认毫秒
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

    /**
     * 获取不到令牌时候的提示语
     */
    String message() default "系统繁忙，请稍后重试";
}
