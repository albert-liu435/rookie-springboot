package com.rookie.bigdata.framework.stereotype.component.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Class B
 * @Description
 * @Author rookie
 * @Date 2024/6/27 15:12
 * @Version 1.0
 */
@Component
public class B {

    public static final Logger logger = LoggerFactory.getLogger(B.class);

    public B() {
        logger.info("com.rookie.bigdata.framework.stereotype.component.bean B construct");
    }
}
