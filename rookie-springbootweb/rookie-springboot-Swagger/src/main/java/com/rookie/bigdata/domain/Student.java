package com.rookie.bigdata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Student
 * @Description Student
 * @Author rookie
 * @Date 2021/6/17 11:38
 * @Version 1.0
 */
@Data
public class Student implements Serializable {


    private Long id;

    @ApiModelProperty(value = "学号")
    private int studentNo;

    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "学生年龄")
    private Integer age;

    @ApiModelProperty(value = "学生出生日期",example = "2018-10-01 12:18:48")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthDate;

}
