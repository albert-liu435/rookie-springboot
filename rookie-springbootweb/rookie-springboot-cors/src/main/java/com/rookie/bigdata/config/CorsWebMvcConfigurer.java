package com.rookie.bigdata.config;

import com.rookie.bigdata.config.properties.CorsProperties;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName CorsConfig
 * @Description CorsConfig
 * @Author rookie  用于配置cors的全局配置
 * @Date 2021/6/18 10:12
 * @Version 1.0
 */
@Configuration
public class CorsWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private CorsProperties corsProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {


        if(corsProperties.isEnable()){

            //用于匹配cross-origin处理的请求路径，如/admin, /admin/**, /**.本实例为全部路径
            registry.addMapping(corsProperties.getPath())

                    //配置请求的origins,如 https://domain1.com
                    .allowedOrigins(StringUtils.join(corsProperties.getAllowedOrigins()))
                    //配置请求的方法
                    .allowedMethods(StringUtils.join(corsProperties.getAllowedMethods()))
                    //是否发送Cookie
                    .allowCredentials(corsProperties.isAllowCredentials())
                    .maxAge(corsProperties.getMaxAge())
                    //暴露哪些原始请求头部信息
                    .allowedHeaders(StringUtils.join(corsProperties.getAllowedHeaders()));
        }



    }
}
