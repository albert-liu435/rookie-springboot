package com.rookie.bigdata.annotation;

import java.lang.annotation.*;

/**
 * @Class SentinelLimitRateAnnotation
 * @Description
 * @Author rookie
 * @Date 2024/8/19 16:12
 * @Version 1.0
 */
@Documented
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SentinelLimitRateAnnotation {

    // 限制类型
    String resourceName();

    // 每秒 5 个
    int limitCount() default 5;

}
