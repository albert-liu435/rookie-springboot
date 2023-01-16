package com.rookie.bigdata.redisson.constant;

/**
 * @Classname GlobalConstant
 * @Description 全局常量枚举 用来拼接完整的URL
 * @Author rookie
 * @Date 2023/1/16 11:22
 * @Version 1.0
 */
public enum GlobalConstant {

    REDIS_CONNECTION_PREFIX("redis://", "Redis地址配置前缀");

    private final String constant_value;
    private final String constant_desc;

    GlobalConstant(String constant_value, String constant_desc) {
        this.constant_value = constant_value;
        this.constant_desc = constant_desc;
    }

    public String getConstant_value() {
        return constant_value;
    }

    public String getConstant_desc() {
        return constant_desc;
    }
}
