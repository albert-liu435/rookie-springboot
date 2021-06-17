//package com.rookie.bigdata.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//
//import java.text.SimpleDateFormat;
//
///**
// * @ClassName JacksonConfig
// * @Description JacksonConfig
// * @Author rookie
// * @Date 2021/6/17 11:55
// * @Version 1.0
// */
//@Configuration
//public class JacksonConfig {
//
//    @Bean("customizeObjectMapper")
//    @Primary
//    @ConditionalOnMissingBean(ObjectMapper.class)
//    public ObjectMapper getObjectMapper(Jackson2ObjectMapperBuilder builder) {
//        ObjectMapper mapper = builder.build();
//
//        // 日期格式
//        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
//
//        // 美化输出
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//        return mapper;
//    }
//}
