package com.rookie.bigdata.annotation;

import com.rookie.bigdata.validator.QsmSpecifiedValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

//import javax.validation.Constraint;
//import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Classname QsmSpecifiedSelector
 * @Description https://blog.csdn.net/u013541707/article/details/110863527
 * @Author rookie
 * @Date 2021/8/18 9:59
 * @Version 1.0
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {QsmSpecifiedValidator.class})
@Repeatable(QsmSpecifiedSelector.List.class)
public @interface QsmSpecifiedSelector {

    //默认错误消息
    String message() default "必须为指定值";

    String[] strValues() default {};

    int[] intValues() default {};

    //使用指定枚举，1、使用属性命名code。2、枚举上使用QsmSpecifiedEnumValue
    Class<?> enumValue() default Class.class;

    //分组
    Class<?>[] groups() default {};

    //负载
    Class<? extends Payload>[] payload() default {};

    //指定多个时使用
    @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        QsmSpecifiedSelector[] value();
    }
}
