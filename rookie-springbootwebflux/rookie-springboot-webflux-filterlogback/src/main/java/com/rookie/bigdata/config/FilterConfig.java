package com.rookie.bigdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.reactive.ServerWebExchangeContextFilter;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 17:58
 * @Version 1.0
 */
@Configuration
public class FilterConfig {

    @Bean
    public ServerWebExchangeContextFilter filter(){
        return new ServerWebExchangeContextFilter();
    }
}
