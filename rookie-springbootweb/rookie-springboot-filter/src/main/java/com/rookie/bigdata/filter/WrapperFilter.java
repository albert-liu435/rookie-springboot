package com.rookie.bigdata.filter;

import com.rookie.bigdata.common.RequestWrapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

/**
 * @Class WrapperFilter
 * @Description https://blog.51cto.com/u_13538361/6383608
 * https://www.cnblogs.com/kevinblandy/p/14742800.html
 * @Author rookie
 * @Date 2024/7/24 13:35
 * @Version 1.0
 */
public class WrapperFilter implements Filter {

//    public class WrapperFilter extends HttpFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WrapperFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        LOGGER.info("WrapperFilter start");
        if (request instanceof HttpServletRequest) {
            ContentCachingRequestWrapper contentCachingRequestWrapper = new ContentCachingRequestWrapper((HttpServletRequest)request);
        }

        if (request instanceof HttpServletResponse) {
            ContentCachingResponseWrapper cachingResponseWrapper = new ContentCachingResponseWrapper((HttpServletResponse)response);
        }

        chain.doFilter(request, response);


        LOGGER.info("WrapperFilter end");



//        try {
//            ServletRequest requestWrapper = null;
//            if (request instanceof HttpServletRequest) {
//                requestWrapper = new RequestWrapper((HttpServletRequest) request);
//            }
//            if (requestWrapper == null) {
//                chain.doFilter(request, response);
//            } else {
//                chain.doFilter(requestWrapper, response);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
