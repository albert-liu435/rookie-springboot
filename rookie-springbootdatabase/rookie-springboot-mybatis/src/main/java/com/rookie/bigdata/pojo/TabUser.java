package com.rookie.bigdata.pojo;

import com.rookie.bigdata.common.enums.AutoId;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TabUser implements Serializable {

//    private static final long serialVersionUID = 1L;
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
