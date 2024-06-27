package com.rookie.bigdata.annotation;

import java.lang.annotation.*;

/**
 * @Class Value
 * @Description https://blog.csdn.net/weixin_43888891/article/details/126963074
 * @Repeatable 注解是用于声明其它类型注解的元注解，来表示这个声明的注解是可重复的。@Repeatable的值是另一个注解，其可以通过这个另一个注解的值来包含这个可重复的注解。
 * @Author rookie
 * @Date 2024/6/27 11:49
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Values.class)
public @interface Value {
    String value() default "value";
}
