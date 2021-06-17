package com.rookie.bigdata.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Student
 * @Description Student
 * @Author liuxili
 * @Date 2021/6/17 11:38
 * @Version 1.0
 */
@Data
public class Student implements Serializable {

    private Long id;

    private int studentNo;

    private String name;

    private Integer age;

    private Date birthDate;

}
