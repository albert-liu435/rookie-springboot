package com.rookie.bigdata.desensitization.strategy.impl;

import com.rookie.bigdata.desensitization.enums.SensitiveTypeEnums;
import com.rookie.bigdata.desensitization.strategy.SensitiveStrategy;

import java.util.regex.Pattern;

/**
 * @Classname IdCardStrategyHandle
 * @Description 身份证号脱敏 330127199911114444转为330127199911114444****
 * @Author rookie
 * @Date 2023/1/13 10:46
 * @Version 1.0
 */
public class IdCardStrategyHandle implements SensitiveStrategy {

    /**
     * 身份证号码位数限制
     */
    public final static String ID_CARD = "^\\d{15}|(\\d{17}[0-9,x,X])$";

    @Override
    public SensitiveTypeEnums getType() {
        return SensitiveTypeEnums.ID_CARD;
    }

    @Override
    public String handle(Object object, String fillValue) {
        if (object == null) {
            return null;
        }
        //字段原始值
        String value = object.toString();
        //如果身份证号不符合格式 直接返回 不进行脱敏
        if (!Pattern.matches(ID_CARD, value)) {
            return value;
        }
        //身份证号脱敏
        return this.rightFill(value, fillValue);
    }
}
