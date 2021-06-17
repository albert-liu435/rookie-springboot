package com.rookie.bigdata.jackson.serializer;


import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @ClassName JacksonDateSerializer
 * @Description JacksonDateSerializer
 * @Author rookie
 * @Date 2021/6/17 13:49
 * @Version 1.0
 */
public class JacksonDateSerializer extends JsonSerializer<Date> {

    /**
     * 对Date日期进行转换为 yyyy-MM-dd HH:mm:ss格式
     *
     * @param date
     * @param gen
     * @param serializers
     * @throws IOException
     */
    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider serializers) throws IOException {

        String format = null;
        if (date != null) {
            format = DateUtil.format(date, DatePattern.NORM_DATETIME_PATTERN);

        }
        gen.writeString(format);


    }
}
