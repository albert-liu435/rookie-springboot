package com.rookie.bigdata.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Class Student
 * @Description
 * @Author rookie
 * @Date 2024/1/17 17:01
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private Long id;

    private String name;

    private int age;

    private int height;

    private Date birth;

    private Character sex;

    //    DATETIME：用于同时存储日期和时间值，格式为'YYYY-MM-DD HH:MM:SS'。
//    TIMESTAMP：用于存储日期和时间戳值，格式同 DATETIME 一致，但其支持更广泛的时间范围。
    private Date createTime;

    private Date createdAt;

}
