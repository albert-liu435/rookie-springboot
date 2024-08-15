package com.rookie.bigdata.domain;

import com.rookie.bigdata.annotation.Desensitization;
import com.rookie.bigdata.enums.DesensitizationType;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description User
 * @Author rookie
 * @Date 2021/6/17 9:33
 * @Version 1.0
 */
@Data
public class User implements Serializable {

    @Desensitization(type = DesensitizationType.ID_CARD,prefixLen = 6,suffixLen = 16)
    private String cardId;

    @Desensitization(type = DesensitizationType.CHINESE_NAME)
    private String name;

    @Desensitization(type = DesensitizationType.MOBILE_PHONE)
    private String phone;

    @Desensitization(type = DesensitizationType.CUSTOMIZE_RULE,prefixLen = 3,suffixLen = 6)
    private String info;


}
