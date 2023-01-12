package com.rookie.bigdata.filter;

import com.rookie.bigdata.common.TrimRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Classname TrimFilter
 * @Description 过滤器 用于去掉参数中的空格
 * @Author rookie
 * @Date 2023/1/12 17:11
 * @Version 1.0
 */
public class TrimFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //自定义TrimRequestWrapper，在这里实现参数去空
        TrimRequestWrapper requestWrapper = new TrimRequestWrapper((HttpServletRequest)request);
        chain.doFilter(requestWrapper, response);

    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}
