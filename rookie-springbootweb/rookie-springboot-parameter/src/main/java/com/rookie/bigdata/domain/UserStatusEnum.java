package com.rookie.bigdata.domain;

/**
 * @Classname UserStatusEnum
 * @Description TODO
 * @Author rookie
 * @Date 2021/8/18 9:43
 * @Version 1.0
 */
/**
 * 用户状态枚举
 */
public enum UserStatusEnum {
    /**正常的*/
    NORMAL,
    /**禁用的*/
    DISABLED,
    /**已删除的*/
    DELETED;

    /**
     * 判断参数合法性
     */
    public static boolean isValidName(String name) {
        for (UserStatusEnum userStatusEnum : UserStatusEnum.values()) {
            if (userStatusEnum.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
