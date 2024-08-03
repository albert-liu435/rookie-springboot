package com.rookie.bigdata.domain;

import com.rookie.bigdata.desensitization.annotation.SensitiveField;
import com.rookie.bigdata.desensitization.enums.SensitiveTypeEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Classname User
 * @Description
 * @Author rookie
 * @Date 2023/1/13 10:52
 * @Version 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 姓名
     */
    @SensitiveField(SensitiveTypeEnums.CHINESE_NAME)
    private String name;

    /**
     * 邮箱
     */
    @SensitiveField(SensitiveTypeEnums.EMAIL)
    private String email;

    /**
     * 手机号
     */
    @SensitiveField(SensitiveTypeEnums.MOBILE)
    private String mobile;

    /**
     * 地址
     */
    @SensitiveField(SensitiveTypeEnums.ADDRESS)
    private String address;


}
