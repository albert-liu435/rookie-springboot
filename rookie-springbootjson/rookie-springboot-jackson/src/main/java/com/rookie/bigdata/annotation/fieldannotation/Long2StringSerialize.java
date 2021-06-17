package com.rookie.bigdata.annotation.fieldannotation;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @ClassName Long2StringSerialize
 * @Description Long2StringSerialize
 * @Author liuxili
 * @Date 2021/6/17 11:06
 * @Version 1.0
 */
public class Long2StringSerialize extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String str = null;
        if (date != null) {
            str = DateUtil.formatDate(date);

        }
        gen.writeString(str);
    }
}
