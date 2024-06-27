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
@AutoConfigureOrder(1)
public class AutoconfigureOrderBeanC {

    public static final Logger logger = LoggerFactory.getLogger(AutoconfigureOrderBeanC.class);


    public AutoconfigureOrderBeanC(){
        logger.info("AutoconfigureOrderBeanC AutoconfigureOrderBean construct");
    }
}
