package com.rookie.bigdata.plugin.desensitization.strategy.impl;


import com.rookie.bigdata.plugin.desensitization.enums.SensitiveTypeEnums;
import com.rookie.bigdata.plugin.desensitization.strategy.SensitiveStrategy;
import org.apache.commons.lang3.StringUtils;

/**
 * @Classname NameStrategyHandle
 * @Description 中文名称脱敏 这个比较特殊。张三 转 张*,李世民->李*民,司徒伯雷->司**雷
 * @Author rookie
 * @Date 2023/1/13 10:47
 * @Version 1.0
 */
public class NameStrategyHandle implements SensitiveStrategy {

    @Override
    public SensitiveTypeEnums getType() {
        return SensitiveTypeEnums.CHINESE_NAME;
    }

    @Override
    public String handle(Object object, String fillValue) {
        if (object == null) {
            return null;
        }
        //字段原始值
        String value = object.toString();
        int length = StringUtils.length(value);
        //如果为2 则说明为右边填充
        if (length == 2) {
            return this.rightFill(value, fillValue);
        }
        //如果大于2 则说明为中间填充
        if (length > 2) {
            return this.centerFill(value, fillValue);
        }
        //如果只有一个子那就直接返回
        return value;
    }

}
