package com.rookie.bigdata.domain;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @ClassName Course
 * @Description Course
 * @Author rookie
 * @Date 2021/6/29 16:33
 * @Version 1.0
 */
public class Course  implements Serializable {

    private Long id;
    @Field(type= FieldType.Keyword)
    private String courseName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
