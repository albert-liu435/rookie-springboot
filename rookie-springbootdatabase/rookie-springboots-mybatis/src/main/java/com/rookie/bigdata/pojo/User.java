package com.rookie.bigdata.pojo;


import com.wky.sensitive.annotation.Replace;
import com.wky.sensitive.rule.Impl.BankCardRuleImpl;
import com.wky.sensitive.rule.Impl.NameRuleImpl;
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
    @Replace(rulePath = NameRuleImpl.class,description = "姓名敏感替换")
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    @Replace(rulePath = BankCardRuleImpl.class,description = "银行卡敏感替换")
    private String mobile;

    /**
     * 地址
     */

    private String address;


}
