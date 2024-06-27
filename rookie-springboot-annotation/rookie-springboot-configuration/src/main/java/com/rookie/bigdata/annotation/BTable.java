package com.rookie.bigdata.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Class BTable
 * @Description
 * @Author rookie
 * @Date 2024/6/27 11:45
 * @Version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BTable {
    public String name() default "";
}
