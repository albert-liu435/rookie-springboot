package com.rookie.bigdata.annotation.custom;

import java.lang.annotation.*;

/**
 * @Class Init
 * @Description
 * @Author rookie
 * @Date 2024/6/27 11:59
 * @Version 1.0
 */
@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})  //可以在字段、枚举的常量、方法
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {
    String value() default "";
}

