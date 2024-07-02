//package com.rookie.bigdata.filter;
//
//import com.rookie.bigdata.common.TrimRequestWrapper;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @Classname TrimFilter2
// * @Description 自定义过滤器  通过继承OncePerRequestFilter实现每次请求该过滤器只被执行一次
// * @Author rookie
// * @Date 2023/1/12 17:31
// * @Version 1.0
// */
//public class TrimFilter2 extends OncePerRequestFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
//            throws ServletException, IOException {
//        //自定义TrimRequestWrapper，在这里实现参数去空
//        TrimRequestWrapper requestWrapper = new TrimRequestWrapper(httpServletRequest);
//        filterChain.doFilter(requestWrapper, httpServletResponse);
//    }
//}
