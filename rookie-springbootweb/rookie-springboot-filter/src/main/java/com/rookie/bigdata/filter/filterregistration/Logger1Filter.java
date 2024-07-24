package com.rookie.bigdata.filter.filterregistration;

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
public class Logger1Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init Logger1Filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Logger1Filter before doFilter");
        chain.doFilter(request, response);
        log.info("Logger1Filter after doFilter");
    }

    @Override
    public void destroy() {

    }
}
