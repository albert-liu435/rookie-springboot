package com.rookie.bigdata.annotation;

import com.rookie.bigdata.enums.LimitTypeEnum;

import java.lang.annotation.*;

/**
 * @Class RedisLimitAnnotation
 * @Description
 * @Author rookie
 * @Date 2024/8/19 16:26
 * @Version 1.0
 */
@Documented
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface RedisLimitAnnotation {

    /**
     * key
     */
    String key() default "";

    /**
     * Key的前缀
     */
    String prefix() default "";

    /**
     * 限流时间内限流次数
     */
    int count();

    /**
     * 限流时间，单位秒
     */
    int period();

    /**
     * 限流的类型(接口、请求ip、用户自定义key)
     */
    LimitTypeEnum limitType() default LimitTypeEnum.INTERFACE;

}
