package com.rookie.bigdata.retry.annotation;

import com.rookie.bigdata.retry.config.AutoProxySelector;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Class EnableRetry
 * @Description https://gitee.com/hacker9/retry-demo
 * @Author rookie
 * @Date 2024/1/2 11:43
 * @Version 1.0
 */
//当没有@Repeatable修饰的时候，注解在同一个位置，只能出现一次
//@Retention：指定注解的生命周期。可选值有三种：SOURCE、CLASS 和 RUNTIME。其中，SOURCE 表示该注解只存在于源代码中，在编译后被丢弃；CLASS 表示该注解在编译后会被保留在 class 文件中，但是在运行时无法获取；RUNTIME 表示该注解在运行时可以被反射机制获取到，默认值为 CLASS。

@Retention(RetentionPolicy.RUNTIME)
//@Target：指定注解的作用范围。可选值包括 ANNOTATION_TYPE、CONSTRUCTOR、FIELD、LOCAL_VARIABLE、METHOD、PACKAGE 和 TYPE。其中，TYPE 表示该注解可以用于类、接口和枚举上
@Target(ElementType.TYPE)
//@Documented：指定该注解是否包含在 JavaDoc 文档中。
@Documented
//@Inherited：指定该注解能否被子类继承。
//https://www.cnblogs.com/xiazhuo/articles/16138882.html
//Import 见名知意：导入某某东西。在平时看源码或者很多配置类上面都会出现@Import注解，功能就是和Spring XML 里面的一样。@Import注解是用来导入配置类或者一些需要前置加载的类
@Import(AutoProxySelector.class)
public @interface EnableRetry {

    boolean proxyTargetClass() default false;

    AdviceMode mode() default AdviceMode.PROXY;
}
