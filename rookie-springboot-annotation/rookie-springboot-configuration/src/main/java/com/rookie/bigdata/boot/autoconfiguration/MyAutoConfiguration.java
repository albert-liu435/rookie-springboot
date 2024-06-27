package com.rookie.bigdata.boot.autoconfiguration;

import com.rookie.bigdata.boot.autoconfiguration.bean.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;


/**
 * @Author rookie
 * @Description
 * @Date 2024/6/26 23:13
 * @Version 1.0
 */

//https://blog.csdn.net/weixin_43888891/article/details/127473290
//@AutoConfiguration需要跟META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports使用，如本例中添加com.rookie.bigdata.autoconfiguration.MyAutoConfiguration使用
@AutoConfiguration

//@AutoConfigureBefore 与@AutoConfigureAfter 用法类似
//@AutoConfigureBefore
//@AutoConfigureAfter
//AutoConfigureOrder
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
