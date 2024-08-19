package com.rookie.bigdata.annotation;

import java.lang.annotation.*;

/**
 * @Class GuavaLimitRateAnnotation
 * @Description
 * @Author rookie
 * @Date 2024/8/19 16:04
 * @Version 1.0
 */
@Documented
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface GuavaLimitRateAnnotation {
    // 限制类型
    String limitType();

    // 每秒 5 个请求
    double limitCount() default 5d;
}
