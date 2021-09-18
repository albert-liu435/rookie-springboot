package com.rookie.bigdata.config;

import com.rookie.bigdata.filter.WrapperFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname WebConfig
 * @Description TODO
 * @Author rookie
 * @Date 2021/9/16 17:46
 * @Version 1.0
 */
@Configuration
public class WebConfig {

    /**
     * 为解决  RequestContextHolder中多次获取请求中数据问题
     * 如下代码：
     * ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
     * HttpServletRequest request = attrs.getRequest();
     * <p>
     * //String s = IoUtil.readUtf8(request.getInputStream());
     * <p>
     * String jsonBody = RequestUtils.getJsonBody(request);
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean reqResFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        WrapperFilter wrapperFilter = new WrapperFilter();
        filterRegistrationBean.setFilter(wrapperFilter);
//        filterRegistrationBean.setOrder(Integer.MAX_VALUE);
//        filterRegistrationBean.setOrder(Integer.MIN_VALUE);
        // filterRegistrationBean.addUrlPatterns("*.json");//配置过滤规则 　　　　 return filterRegistrationBean;
        return filterRegistrationBean;
    }
}