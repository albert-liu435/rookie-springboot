package com.rookie.bigdata.config;

import com.rookie.bigdata.filter.TrimFilter;
import com.rookie.bigdata.filter.TrimFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 * @Classname FilterConfig
 * @Description
 * @Author rookie
 * @Date 2023/1/12 16:58
 * @Version 1.0
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean trimFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setDispatcherTypes(DispatcherType.REQUEST);
        //注册自定义过滤器
        registration.setFilter(new TrimFilter());
        //过滤所有路径
        registration.addUrlPatterns("/*");
//        //过滤器名称
//        registration.setName("trimFilter");
//        //优先级越低越优先，这里说明最低优先级
//        registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registration;
    }
}
