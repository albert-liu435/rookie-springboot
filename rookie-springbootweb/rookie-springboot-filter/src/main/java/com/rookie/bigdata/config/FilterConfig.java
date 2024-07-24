package com.rookie.bigdata.config;


import com.rookie.bigdata.filter.WrapperFilter;
import com.rookie.bigdata.filter.filterregistration.Logger1Filter;
import com.rookie.bigdata.filter.filterregistration.Logger2Filter;
import com.rookie.bigdata.filter.filterregistration.Logger3Filter;
import jakarta.servlet.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;


/**
 * @Classname FilterConfig
 * @Description
 * @Author rookie
 * @Date 2023/1/12 16:58
 * @Version 1.0
 */
@Configuration
@Slf4j
public class FilterConfig {



    @Bean
    public FilterRegistrationBean<WrapperFilter> wrapperFilter() {
        FilterRegistrationBean<WrapperFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WrapperFilter());    // 这里可以使用 new，也可以在 Filter 上加 @Component 注入进来
        bean.addUrlPatterns("/*"); //配置过滤规则
        bean.setName("wrapperFilter");
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);    // 值越小，优先级越高
        return bean;
    }







    //Component注解的方式进行过滤请求
    @Bean
    @Order(-3) //这个指定的顺序不起作用
    public Filter ComponentUser4Filter() {
        return (request, response, chain) -> {
            log.info("ComponentUser4Filter doFilter");
            chain.doFilter(request, response);
        };
    }


    //使用包装Bean注入（ FilterRegistrationBean）
    @Bean
    public FilterRegistrationBean<Logger1Filter> logger1Filter() {
        FilterRegistrationBean<Logger1Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new Logger1Filter());    // 这里可以使用 new，也可以在 Filter 上加 @Component 注入进来
        bean.addUrlPatterns("/*"); //配置过滤规则
        bean.setName("logger1Filter");
        bean.setOrder(10);    // 值越小，优先级越高
        return bean;
    }

    @Bean
    public FilterRegistrationBean<Logger2Filter> logger2Filter() {
        FilterRegistrationBean<Logger2Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new Logger2Filter());    // 这里可以使用 new，也可以在 Filter 上加 @Component 注入进来
        bean.addUrlPatterns("/*"); //配置过滤规则
        bean.setName("logger2Filter");
        bean.setOrder(1000);    // 值越小，优先级越高
        return bean;
    }


    @Bean
    public FilterRegistrationBean<Logger3Filter> logger3Filter() {
        FilterRegistrationBean<Logger3Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new Logger3Filter());    // 这里可以使用 new，也可以在 Filter 上加 @Component 注入进来
        bean.addUrlPatterns("/*"); //配置过滤规则
        bean.setName("logger3Filter");
        bean.setOrder(100);    // 值越小，优先级越高
        return bean;
    }

    //使用包装Bean注入（ FilterRegistrationBean）

//
//    /**
//     * 在上面 3 中，我们给 Filter 类上加了 @Component 注解，但是那种方式不能指定过滤规则，我们可以使用 SpringBoot 提供的 DelegatingFilterProxyRegistrationBean 来解决这个问题
//     * <p>
//     * DelegatingFilterProxyRegistrationBean 通过传入的 targetBeanName 在 IoC 容器 中查找该 Filter 的 Bean，并通过 DelegatingFilterProxy 生成基于该 Bean 的代理 Filter 对象，
//     * 而 FilterRegistrationBean 则是直接设置一个 Filter，因此该 Filter 可以被 Spring 管理也可以不用被 Spring 管理，在被 Spring 管理的情况下，可以不定义 FilterRegistrationBean，也就是第 3 种方式，这种方式无法定义拦截规则，默认过滤所有请求。
//     *
//     * @return
//     */
//    @Bean
//    public DelegatingFilterProxyRegistrationBean delegatingFilterProxyRegistrationBean() {
//        // 构造器参数填的就是 targetBeanName，即 Filter 在 IoC 容器中的 Bean 名称
//        DelegatingFilterProxyRegistrationBean helloFilter = new DelegatingFilterProxyRegistrationBean("componentFilter");
//        helloFilter.addUrlPatterns("/hello");
//        return helloFilter;
//    }
//
////    @Bean
////    public FilterRegistrationBean trimFilterRegistration() {
////        FilterRegistrationBean registration = new FilterRegistrationBean();
//////        registration.setDispatcherTypes(DispatcherType.REQUEST);
////        //注册自定义过滤器
////        registration.setFilter(new TrimFilter());
////        //过滤所有路径
////        registration.addUrlPatterns("/*");
//////        //过滤器名称
//////        registration.setName("trimFilter");
//////        //优先级越低越优先，这里说明最低优先级
//////        registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
////        return registration;
////    }
}
