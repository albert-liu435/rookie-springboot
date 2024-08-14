package com.rookie.bigdata.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/13 21:03
 * @Version 1.0
 */
@Configuration(proxyBeanMethods = false)
public class RestTemplateConfiguration {
    @Bean
    public RestTemplate oauth2ClientRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
