package com.rookie.bigdata.filter;


import com.rookie.bigdata.common.RequestWrapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;


import java.io.IOException;

/**
 * @Classname WrapperFilter
 * @Description @Description: 拦截所有请求过滤器，并将请求类型是HttpServletRequest类型的请求替换为自定义{@link com.rookie.bigdata.common.RequestWrapper}
 * @Author rookie
 * @Date 2021/9/16 17:42
 * @Version 1.0
 */
//@Component
//@WebFilter(filterName = "channelFilter", urlPatterns = {"/*"})
public class WrapperFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            ServletRequest requestWrapper = null;
            if (request instanceof HttpServletRequest) {
                requestWrapper = new RequestWrapper((HttpServletRequest) request);
            }
            if (requestWrapper == null) {
                chain.doFilter(request, response);
            } else {
                chain.doFilter(requestWrapper, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void destroy() {
    }

}
