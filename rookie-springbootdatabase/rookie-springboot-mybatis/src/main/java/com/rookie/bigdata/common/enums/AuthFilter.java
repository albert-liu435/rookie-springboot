package com.rookie.bigdata.common.enums;

import java.lang.annotation.*;

/**
 * @Class AuthFilter
 * @Description
 * @Author rookie
 * @Date 2024/11/13 16:24
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD , ElementType.TYPE})
@Documented
public @interface AuthFilter {

    String userFiled() default "userId";

    String orgFiled() default "orgId";

    boolean ignoreUserFiled() default false;

    boolean ignoreOrgFiled() default false;
}
