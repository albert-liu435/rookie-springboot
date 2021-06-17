package com.rookie.bigdata.annotation;

import java.lang.annotation.*;

/**
 * @ClassName Log
 * @Description Log  自定义注解
 * @Author rookie
 * @Date 2021/6/17 16:14
 * @Version 1.0
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
}
