package com.rookie.bigdata.config;

import com.rookie.bigdata.plugin.AutoIdInterceptor;
import com.rookie.bigdata.plugin.CustomerInterceptor;
import com.rookie.bigdata.plugin.desensitization.plugin.DesensitizationInterceptor;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Class MybatisInterceptorConfig
 * @Description 用于配置mybatis Interceptor
 * @Author rookie
 * @Date 2024/11/13 15:49
 * @Version 1.0
 */
@Configuration
public class MybatisInterceptorConfig {


    @Bean
    CustomerInterceptor customerInterceptor() {
        return new CustomerInterceptor();
    }

    @Bean
    AutoIdInterceptor autoIdInterceptor() {
        return new AutoIdInterceptor();
    }


    @Bean
    DesensitizationInterceptor desensitizationInterceptor() {
        return new DesensitizationInterceptor();
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.addInterceptor(customerInterceptor());
                configuration.addInterceptor(autoIdInterceptor());
            }
        };
    }
}
