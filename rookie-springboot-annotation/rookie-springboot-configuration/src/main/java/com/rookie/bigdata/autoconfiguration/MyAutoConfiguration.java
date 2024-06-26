package com.rookie.bigdata.autoconfiguration;

import com.rookie.bigdata.autoconfiguration.bean.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author rookie
 * @Description
 * @Date 2024/6/26 23:13
 * @Version 1.0
 */

//https://blog.csdn.net/weixin_43888891/article/details/127473290
@AutoConfiguration
//@Configuration

//@Configuration(proxyBeanMethods = false)
//@ConditionalOnClass(A.class)
public class MyAutoConfiguration {

    public static final Logger logger = LoggerFactory.getLogger(MyAutoConfiguration.class);


    @Bean
    @ConditionalOnMissingBean
    public A createA() {

        A a = new A();

        logger.info("实例化MyAutoConfigurationBean {}", a);

        return a;
    }

//ConditionalOnClass


//    @AutoConfiguration
//    public class MyAutoConfiguration {
//
//        @Configuration(proxyBeanMethods = false)
//        @ConditionalOnClass(SomeService.class)
//        public static class SomeServiceConfiguration {
//
//            @Bean
//            @ConditionalOnMissingBean
//            public SomeService someService() {
//                return new SomeService();
//            }
//
//        }
//
//    }
}
