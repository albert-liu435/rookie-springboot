package com.rookie.bigdata.framework.stereotype.component.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @Class A
 * @Description 实例化顺序： A > B > C
 * @Author rookie
 * @Date 2024/6/27 15:09
 * @Version 1.0
 */
@Component
public class A {

    public static final Logger logger = LoggerFactory.getLogger(A.class);

    public A() {
        logger.info(" com.rookie.bigdata.framework.stereotype.component.bean A construct");
    }
}
