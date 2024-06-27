package com.rookie.bigdata.annotation.custom;

/**
 * @Class User
 * @Description
 * @Author rookie
 * @Date 2024/6/27 11:59
 * @Version 1.0
 */
public class User {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    @Init("louis")
    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    @Init("22")
    public User setAge(String age) {
        this.age = age;
        return this;
    }
}
