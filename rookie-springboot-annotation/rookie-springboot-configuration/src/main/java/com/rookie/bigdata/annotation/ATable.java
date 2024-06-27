package com.rookie.bigdata.annotation;

import java.lang.annotation.*;

/**
 * @Class ATable
 * @Description https://blog.csdn.net/weixin_43888891/article/details/126963074
 * @Author rookie
 * @Date 2024/6/27 11:45
 * @Version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ATable {
    public String name() default "";
}
