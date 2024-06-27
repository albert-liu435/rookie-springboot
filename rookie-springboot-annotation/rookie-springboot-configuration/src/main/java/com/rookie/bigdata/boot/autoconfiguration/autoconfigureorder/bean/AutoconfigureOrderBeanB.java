package com.rookie.bigdata.boot.autoconfiguration.autoconfigureorder.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;

/**
 * @Class AutoconfigureOrderBeanA
 * @Description
 * @Author rookie
 * @Date 2024/6/27 15:24
 * @Version 1.0
 */
//@Configuration
@AutoConfigureOrder(2)
public class AutoconfigureOrderBeanB {

    public static final Logger logger = LoggerFactory.getLogger(AutoconfigureOrderBeanB.class);


    public AutoconfigureOrderBeanB(){
        logger.info("AutoconfigureOrderBeanB AutoconfigureOrderBean construct");
    }
}
