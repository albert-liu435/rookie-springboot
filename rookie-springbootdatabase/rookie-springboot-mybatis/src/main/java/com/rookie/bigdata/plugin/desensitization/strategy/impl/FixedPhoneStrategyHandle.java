package com.rookie.bigdata.plugin.desensitization.strategy.impl;



import com.rookie.bigdata.plugin.desensitization.enums.SensitiveTypeEnums;
import com.rookie.bigdata.plugin.desensitization.strategy.SensitiveStrategy;

import java.util.regex.Pattern;

/**
 * @Classname FixedPhoneStrategyHandle
 * @Description 座机电话号脱敏 0211-8711882转为0211-871****
 * @Author rookie
 * @Date 2023/1/13 10:45
 * @Version 1.0
 */
public class FixedPhoneStrategyHandle implements SensitiveStrategy {

    /**
     * 身份证号码位数限制 匹配形式如 0511-4405222 或 021-87888822
     */
    public final static String FIXED_PHONE = "^\\d{3}-\\d{7,8}|\\d{4}-\\d{7,8}$";

    @Override
    public SensitiveTypeEnums getType() {
        return SensitiveTypeEnums.FIXED_PHONE;
    }

    @Override
    public String handle(Object object, String fillValue) {
        if (object == null) {
            return null;
        }
        //字段原始值
        String value = object.toString();
        //如果座机不符合格式 直接返回 不进行脱敏
        if (!Pattern.matches(FIXED_PHONE, value)) {
            return value;
        }
        //座机脱敏
        return this.rightFill(value, fillValue);
    }
}
