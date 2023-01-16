package com.rookie.bigdata.redisson.annotation;

import java.lang.annotation.*;

/**
 * @Classname DistributedLock
 * @Description 基于注解的分布式式锁
 * @Author rookie
 * @Date 2023/1/16 11:19
 * @Version 1.0
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DistributedLock {

    /**
     * 锁的名称
     */
    String value() default "redisson";

    /**
     * 锁的有效时间
     */
    int leaseTime() default 10;
}
