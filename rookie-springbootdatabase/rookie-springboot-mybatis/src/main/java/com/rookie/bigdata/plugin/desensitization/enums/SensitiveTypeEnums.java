package com.rookie.bigdata.plugin.desensitization.enums;

/**
 * @Classname SensitiveTypeEnums
 * @Description 脱敏类型
 * @Author rookie
 * @Date 2023/1/13 10:38
 * @Version 1.0
 */
public enum SensitiveTypeEnums {

    /**
     * 默认方式脱敏
     */
    DEFAULT(0, 6),

    /**
     * 中文名称
     */
    CHINESE_NAME(1, 1),

    /**
     * 手机号
     */
    MOBILE(3, 4),

    /**
     * 座机号码
     */
    FIXED_PHONE(0, 4),

    /**
     * 银行卡
     */
    BANK_CARD(6, 4),

    /**
     * 身份证号
     */
    ID_CARD(0, 4),

    /**
     * 邮箱
     */
    EMAIL(2, 0),

    /**
     * 地址
     */
    ADDRESS(6, 4),

    ;

    SensitiveTypeEnums(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    ;

    /**
     * 开始长度
     */
    private int begin;

    /**
     * 结束长度
     */
    private int end;

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }
}
