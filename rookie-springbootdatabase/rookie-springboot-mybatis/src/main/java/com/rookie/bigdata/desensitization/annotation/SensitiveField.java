package com.rookie.bigdata.desensitization.annotation;

import com.rookie.bigdata.desensitization.enums.SensitiveTypeEnums;

import java.lang.annotation.*;

/**
 * @Classname SensitiveField
 * @Description 对需要脱敏的字段加上该注解
 * @Author rookie
 * @Date 2023/1/13 10:37
 * @Version 1.0
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface SensitiveField {

    /**
     * 脱敏类型
     */
    SensitiveTypeEnums value();

    /**
     * 填充值
     */
    String fillValue() default "*";

}
