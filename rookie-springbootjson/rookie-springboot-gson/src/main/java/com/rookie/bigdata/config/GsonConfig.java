//package com.rookie.bigdata.config;
//
//import cn.hutool.core.date.DatePattern;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.json.GsonHttpMessageConverter;
//
//import java.lang.reflect.Modifier;
//
///**
// * @ClassName GsonConfig
// * @Description GsonConfig
// * @Author rookie
// * @Date 2021/6/17 14:23
// * @Version 1.0
// */
//@Configuration
//public class GsonConfig {
//
////    @Bean
////    public HttpMessageConverters customConverters(){
////        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
////
////        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
////        messageConverters.add(gsonHttpMessageConverter);
////
////        return new HttpMessageConverters(true, messageConverters);
////    }
//
//
//    @Bean
//    GsonHttpMessageConverter gsonHttpMessageConverter() {
//
//        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
//
//        GsonBuilder builder = new GsonBuilder();
//        //设置解析日期的格式
//        builder.setDateFormat(DatePattern.NORM_DATETIME_PATTERN);
//        //设置gson解析时修饰符为protected的字段被过滤掉
//        builder.excludeFieldsWithModifiers(Modifier.PROTECTED);
//
//
//
//        Gson gson = builder.create();
//
//        converter.setGson(gson);
//
//        return converter;
//
//    }
//}
