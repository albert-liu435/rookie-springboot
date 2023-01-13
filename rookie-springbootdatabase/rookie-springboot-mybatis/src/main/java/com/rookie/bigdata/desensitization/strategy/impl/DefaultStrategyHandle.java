package com.rookie.bigdata.desensitization.strategy.impl;

import com.rookie.bigdata.desensitization.enums.SensitiveTypeEnums;
import com.rookie.bigdata.desensitization.strategy.SensitiveStrategy;
import org.apache.commons.lang3.StringUtils;

/**
 * @Classname DefaultStrategyHandle
 * @Description 默认脱敏方式
 * @Author rookie
 * @Date 2023/1/13 10:44
 * @Version 1.0
 */
public class DefaultStrategyHandle implements SensitiveStrategy {


    @Override
    public SensitiveTypeEnums getType() {
        return SensitiveTypeEnums.DEFAULT;
    }

    @Override
    public String handle(Object object, String fillValue) {
        if (object == null) {
            return null;
        }
        //字段原始值
        String value = object.toString();
        SensitiveTypeEnums type = getType();
        int end = type.getEnd();
        int length = StringUtils.length(value);
        if (end < length) {
            return this.rightFill(value, fillValue);
        }
        return value;
    }
}