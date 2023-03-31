package com.rookie.bigdata.beans.propertyeditors;

import lombok.Data;

import java.util.Date;

/**
 * @Class Person
 * @Description
 * @Author rookie
 * @Date 2023/4/1 1:20
 * @Version 1.0
 */
//@Data
public class Person {

    private String name;

    private String gender;

    private Integer age;

    private Date birthDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
