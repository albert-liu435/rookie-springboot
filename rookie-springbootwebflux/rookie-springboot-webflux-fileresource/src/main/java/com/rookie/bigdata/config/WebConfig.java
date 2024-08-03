package com.rookie.bigdata.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.multipart.DefaultPartHttpMessageReader;
import org.springframework.http.codec.multipart.MultipartHttpMessageReader;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 21:24
 * @Version 1.0
 */
@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {

        DefaultPartHttpMessageReader partReader=new DefaultPartHttpMessageReader();

//        SynchronossPartHttpMessageReader partReader = new SynchronossPartHttpMessageReader();
//        partReader.setMaxParts(1024);
//        //字节bytes
//        partReader.setMaxDiskUsagePerPart(1024 *1000000);
//        partReader.setEnableLoggingRequestDetails(true);

        // 单文件上传大小限制
        MultipartHttpMessageReader multipartReader = new MultipartHttpMessageReader(partReader);
        multipartReader.setEnableLoggingRequestDetails(true);
        configurer.defaultCodecs().multipartReader(multipartReader);



    }
}
