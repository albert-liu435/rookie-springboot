//package com.rookie.bigdata.config;
//
//import com.rookie.bigdata.filter.TrimFilter;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @Classname DefaultMvcConfig
// * @Description
// * @Author rookie
// * @Date 2023/1/12 17:48
// * @Version 1.0
// */
//@Configuration
//@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
//public class DefaultMvcConfig implements WebMvcConfigurer {
//
//
//    //add filter
//    //registration.addUrlPatterns("/icons/*", "/style/*", "/script/*", "/dwr/*", "/icons/*", "/coverArt.view", "/avatar.view");
//    //registration.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");
//
//    @Bean
//    public FilterRegistrationBean addTimeFilterBean() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new TrimFilter());
//        registration.setName("timeFilter");
//        registration.setOrder(1);  //请求中过滤器执行的先后顺序，值越小越先执行
//        registration.addUrlPatterns("/home/*","/abc/*");
//        return registration;
//    }
//
//}
