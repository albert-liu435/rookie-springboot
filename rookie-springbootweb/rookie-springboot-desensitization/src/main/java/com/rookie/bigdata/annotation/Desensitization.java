package com.rookie.bigdata.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rookie.bigdata.enums.DesensitizationType;
import com.rookie.bigdata.serializer.SensitiveInfoSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Class Desensitization
 * @Description https://www.51cto.com/article/769029.html
 * @Author rookie
 * @Date 2024/8/15 9:12
 * @Version 1.0
 */

//@JsonSerialize(using = SensitiveInfoSerializer.class)用于指定在序列化时应该使用哪个自定义序列化器类
//「需要和下面的注解搭配使用SensitiveInfoSerializer我们自定义的序列化器才会生效」
//
//@JacksonAnnotationsInside 主要用于标记其他自定义注解，这意味着你可以在一个 Jackson 注解内部使用其他自定义注解，以组合各种注解来实现更复杂的序列化和反序列化逻辑。
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveInfoSerializer.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Desensitization {
    DesensitizationType type() default DesensitizationType.DEFAULT;

    /**
     * 前置不需要打码的长度
     */
    int prefixLen() default 0;

    /**
     * 后置不需要打码的长度
     */
    int suffixLen() default 0;

    /**
     * 遮罩字符
     */
    String maskingChar() default "*";
}
