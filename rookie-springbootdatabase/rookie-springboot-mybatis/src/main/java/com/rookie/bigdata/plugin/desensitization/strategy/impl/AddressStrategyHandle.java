package com.rookie.bigdata.plugin.desensitization.strategy.impl;


import com.rookie.bigdata.plugin.desensitization.enums.SensitiveTypeEnums;
import com.rookie.bigdata.plugin.desensitization.strategy.SensitiveStrategy;
import org.apache.commons.lang3.StringUtils;

/**
 * @Classname AddressStrategyHandle
 * @Description 地址填充: 宁波市慈溪市观海卫镇禹皇路999号鸣鹤古镇 转为 宁波市慈溪市***********鸣鹤古镇
 * @Author rookie
 * @Date 2023/1/13 10:43
 * @Version 1.0
 */
public class AddressStrategyHandle implements SensitiveStrategy {

    @Override
    public SensitiveTypeEnums getType() {
        return SensitiveTypeEnums.ADDRESS;
    }

    @Override
    public String handle(Object object, String fillValue) {
        if (object == null) {
            return null;
        }
        //字段原始值
        String value = object.toString();
        SensitiveTypeEnums type = getType();
        int begin = type.getBegin();
        int end = type.getEnd();
        int length = StringUtils.length(value);
        //如果开始+结束 < 地址总长度 那就可以中间填充
        if (end + begin < length) {
            return this.centerFill(value, fillValue);
        }

        //如果开始+结束 > 地址总长度 同时 结束 < 地址总长度 那么右边填充
        if (end + begin < length && end < length) {
            return this.rightFill(value, fillValue);
        }
        return value;
    }

}
