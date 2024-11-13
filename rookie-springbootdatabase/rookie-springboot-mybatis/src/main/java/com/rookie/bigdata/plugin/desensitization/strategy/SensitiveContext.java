package com.rookie.bigdata.plugin.desensitization.strategy;


import com.rookie.bigdata.plugin.desensitization.enums.SensitiveTypeEnums;
import com.rookie.bigdata.plugin.desensitization.strategy.impl.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname SensitiveContext
 * @Description 获取所有策略
 * @Author rookie
 * @Date 2023/1/13 10:43
 * @Version 1.0
 */
@Component
public class SensitiveContext {

    private static final Map<SensitiveTypeEnums,SensitiveStrategy> map = new ConcurrentHashMap<>();

    static {
        map.put(SensitiveTypeEnums.DEFAULT,new DefaultStrategyHandle());
        map.put(SensitiveTypeEnums.CHINESE_NAME,new NameStrategyHandle());
        map.put(SensitiveTypeEnums.MOBILE,new MobileStrategyHandle());
        map.put(SensitiveTypeEnums.FIXED_PHONE,new FixedPhoneStrategyHandle());
        map.put(SensitiveTypeEnums.BANK_CARD,new BankCardStrategyHandle());
        map.put(SensitiveTypeEnums.ID_CARD,new IdCardStrategyHandle());
        map.put(SensitiveTypeEnums.EMAIL,new EmailStrategyHandle());
        map.put(SensitiveTypeEnums.ADDRESS,new AddressStrategyHandle());
    }


    public static SensitiveStrategy get(SensitiveTypeEnums sensitiveType){

        SensitiveStrategy eensitiveStrategy =  map.get(sensitiveType);
        Assert.notNull(eensitiveStrategy,"eensitiveStrategy no found!");
        return eensitiveStrategy;
    }


}
