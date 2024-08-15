package com.rookie.bigdata.serializer;

import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.rookie.bigdata.annotation.Desensitization;
import com.rookie.bigdata.enums.DesensitizationType;

import java.io.IOException;

/**
 * @Class SensitiveInfoSerializer
 * @Description 数据脱敏序列化器
 * @Author rookie
 * @Date 2024/8/15 9:17
 * @Version 1.0
 */

//关于自定义的规则，大家可以根据自己的需求来写工具类，我这里简单使用Hutool的工具来了！
//
//StrUtil.replace(value, prefixLen, suffixLen, maskingChar)StrUtil.hide(value, prefixLen, suffixLen)
//
//createContextual 方法首先在序列化过程开始时被调用，返回的序列化器实例将用于后续的序列化过程。
//
//serialize 方法负责实际的序列化逻辑，将字段的值转换为JSON，并可以在其中执行自定义的脱敏逻辑

public class SensitiveInfoSerializer extends JsonSerializer<String> implements ContextualSerializer {

    private boolean useMasking = false;
    private DesensitizationType type;
    private int prefixLen;
    private int suffixLen;
    private String maskingChar;

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (useMasking && value != null) {
            switch (type) {
                case MOBILE_PHONE:
                    gen.writeString(DesensitizedUtil.mobilePhone(value));
                    break;
                case ID_CARD:
                    gen.writeString(DesensitizedUtil.idCardNum(value, prefixLen, suffixLen));
                    break;
                case CUSTOMIZE_RULE:
//                    gen.writeString(StrUtil.replace(value, prefixLen, suffixLen, maskingChar));
                    gen.writeString(StrUtil.hide(value, prefixLen, suffixLen));
                    break;
                case CHINESE_NAME:
                    gen.writeString(DesensitizedUtil.chineseName(value));
                    break;
                case DEFAULT:
                    gen.writeString(value);
                default:
                    gen.writeString(value);
            }
        } else {
            gen.writeObject(value);
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) {
        if (property != null) {
            Desensitization desensitization = property.getAnnotation(Desensitization.class);
            if (desensitization != null) {
                this.type = desensitization.type();
                this.prefixLen = desensitization.prefixLen();
                this.suffixLen = desensitization.suffixLen();
                this.maskingChar = desensitization.maskingChar();
                useMasking = true;
            }
        }
        return this;
    }
}
