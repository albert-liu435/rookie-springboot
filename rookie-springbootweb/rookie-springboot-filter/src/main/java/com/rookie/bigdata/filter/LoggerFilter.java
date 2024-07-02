package com.rookie.bigdata.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Class LogFilter
 * @Description
 * @Author rookie
 * @Date 2024/7/2 11:25
 * @Version 1.0
 */
@Slf4j
public class LoggerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init LoggerFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("LoggerFilter before doFilter");
        chain.doFilter(request, response);
        log.info("LoggerFilter after doFilter");
    }

    @Override
    public void destroy() {

    }
}
