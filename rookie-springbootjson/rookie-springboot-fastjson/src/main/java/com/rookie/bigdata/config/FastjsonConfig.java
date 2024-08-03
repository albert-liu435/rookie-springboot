package com.rookie.bigdata.config;



import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

/**
 * @ClassName GsonConfig
 * @Description GsonConfig https://mp.weixin.qq.com/s?__biz=MzAxMjY5NDU2Ng==&mid=2651869010&idx=1&sn=9b69f24046573fe30a99b66227292af9&chksm=817288795102bcf3e44ac37c66e331adab339377b907c933615f7138c26a6174ce0009e9666a&scene=27
 * @Author rookie
 * @Date 2021/6/17 14:23
 * @Version 1.0
 */
@Configuration
public class FastjsonConfig {


    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd");
        config.setCharset(Charset.forName("UTF-8"));
        config.setWriterFeatures(JSONWriter.Feature.WriteMapNullValue,JSONWriter.Feature.PrettyFormat,JSONWriter.Feature.WriteNullListAsEmpty,JSONWriter.Feature.WriteNullStringAsEmpty);
//        config.setSerializerFeatures(
//                //  SerializerFeature.WriteClassName,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.PrettyFormat,
//                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteNullStringAsEmpty
//        );
        converter.setFastJsonConfig(config);


        return converter;
    }
}
