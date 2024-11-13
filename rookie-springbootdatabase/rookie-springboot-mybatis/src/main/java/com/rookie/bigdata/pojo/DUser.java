package com.rookie.bigdata.pojo;

import com.rookie.bigdata.plugin.desensitization.annotation.SensitiveField;
import com.rookie.bigdata.plugin.desensitization.enums.SensitiveTypeEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Class DUser
 * @Description
 * @Author rookie
 * @Date 2024/11/13 16:51
 * @Version 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@ToString
public class DUser implements Serializable {


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
