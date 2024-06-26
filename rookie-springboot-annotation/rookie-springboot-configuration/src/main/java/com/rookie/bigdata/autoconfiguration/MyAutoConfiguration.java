package com.rookie.bigdata.autoconfiguration;

import com.rookie.bigdata.autoconfiguration.bean.MyAutoConfigurationBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Author rookie
 * @Description
 * @Date 2024/6/26 23:13
 * @Version 1.0
 */

//https://blog.csdn.net/weixin_43888891/article/details/127473290
@AutoConfiguration
public class MyAutoConfiguration {

    public static final Logger logger= LoggerFactory.getLogger(MyAutoConfiguration.class)


    @Bean
    public MyAutoConfigurationBean myAutoConfigurationBean(){

        MyAutoConfigurationBean myAutoConfigurationBean = new MyAutoConfigurationBean();

        logger.info("实例化MyAutoConfigurationBean {}",myAutoConfigurationBean);

        return myAutoConfigurationBean;
    }
}
