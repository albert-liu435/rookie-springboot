package com.rookie.bigdata.domain;

import com.rookie.bigdata.plugin.AutoId;
import lombok.Data;

import java.util.Date;

/**
 * @Classname TabUser
 * @Description
 * @Author rookie
 * @Date 2023/1/13 16:36
 * @Version 1.0
 */
@Data
public class TabUser {
    /**
     * id(添加自定义主键ID)
     */
    @AutoId
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * 是否删除 1删除 0未删除
     */
    private Integer status;

}