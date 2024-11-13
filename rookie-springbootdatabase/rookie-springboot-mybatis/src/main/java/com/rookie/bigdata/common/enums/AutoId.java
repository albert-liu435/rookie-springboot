package com.rookie.bigdata.common.enums;

import java.lang.annotation.*;

/**
 * @Class AutoId
 * @Description 主键注解
 * 支持两种主键：雪花ID 和 UUID
 * @Author rookie
 * @Date 2024/11/13 16:02
 * @Version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutoId {

    /**
     * @return id类型（默认为雪花id）
     */
    IdType value() default IdType.SNOWFLAKE;

    /**
     * id类型
     */
    enum IdType {
        /**
         * UUID去掉“-”
         */
        UUID,
        /**
         * 雪花id
         */
        SNOWFLAKE
    }

}
