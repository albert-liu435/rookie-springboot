package com.rookie.bigdata.enums;

/**
 * @Class LimitTypeEnum
 * @Description
 * @Author rookie
 * @Date 2024/8/19 16:27
 * @Version 1.0
 */
@Getter
public enum LimitTypeEnum {

    // 默认限流策略，针对某一个接口进行限流
    INTERFACE
    ,

    // 根据IP地址进行限流
    IP
    ,

    // 自定义的Key
    CUSTOMER
    ;

}
