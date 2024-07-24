package com.rookie.bigdata.filter.web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import java.io.IOException;

/**
 * @Class MyCustomerFilter
 * @Description
 * @Author rookie
 * @Date 2024/7/2 11:11
 * @Version 1.0
 */
//@ServletComponentScan(basePackages = "com.rookie.bigdata.filter.web")使用该注解必须添加这个注解
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
@Slf4j
public class MyCustomerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化我的过滤器MyCustomerFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("原生Filter-MyCustomerFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
