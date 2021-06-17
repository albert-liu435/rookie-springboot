package com.rookie.bigdata.jackson.deserializer;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * @ClassName JacksonDateDeserializer
 * @Description JacksonDateDeserializer
 * @Author liuxili
 * @Date 2021/6/17 13:59
 * @Version 1.0
 */
public class JacksonDateDeserializer extends JsonDeserializer<Date> {

    /**
     * 反序列化，将日期字符串形式转换为Date类型
     *
     * @param jp
     * @param ctxt
     * @return
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = jp.getText();

        DateTime parse = DateUtil.parse(date);
        return parse;
    }

}