package com.rookie.bigdata.annotation;

import com.rookie.bigdata.enums.BusinessType;
import com.rookie.bigdata.enums.OperatorType;

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
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    public boolean isSaveResponseData() default true;
}
