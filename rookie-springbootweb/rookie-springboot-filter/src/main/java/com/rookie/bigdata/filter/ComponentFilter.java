package com.rookie.bigdata.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Class ComponentFilter
 * @Description
 * @Author rookie
 * @Date 2024/7/2 11:30
 * @Version 1.0
 */
@Component
@Order(-1)	// 可以指定优先级，不填的话默认为最小的优先级
@Slf4j
public class ComponentFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init ComponentFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("ComponentFilter doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

