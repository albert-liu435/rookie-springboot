package com.rookie.bigdata.plugin.desensitization.annotation;


import com.rookie.bigdata.plugin.desensitization.enums.SensitiveTypeEnums;

import java.lang.annotation.*;

/**
 * @Classname SensitiveField
 * @Description 对需要脱敏的字段加上该注解 参考 https://www.cnblogs.com/qdhxhz/p/16352087.html
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
