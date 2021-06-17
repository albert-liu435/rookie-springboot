package com.rookie.bigdata.config;

import cn.hutool.core.date.DatePattern;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @ClassName GsonWebConfigurer
 * @Description GsonWebConfigurer
 * @Author rookie
 * @Date 2021/6/17 14:28
 * @Version 1.0
 */
@Configuration
public class GsonWebConfigurer implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();

        GsonBuilder builder = new GsonBuilder();
        //设置解析日期的格式
        builder.setDateFormat(DatePattern.NORM_DATETIME_PATTERN);
        //设置gson解析时修饰符为protected的字段被过滤掉
        builder.excludeFieldsWithModifiers(Modifier.PROTECTED);



        Gson gson = builder.create();

        converter.setGson(gson);


        converters.add(converter);
    }
}
