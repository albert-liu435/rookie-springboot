package com.rookie.bigdata.annotation.fieldannotation;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * @ClassName Long2DateSerialize
 * @Description Long2DateSerialize
 * @Author liuxili
 * @Date 2021/6/17 11:16
 * @Version 1.0
 */
public class Long2DateDeserialize extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if(null!=p && null!=ctxt && p.getLongValue()>0L ) {
            return new Date(p.getLongValue());
        }

        return null;
    }


}
