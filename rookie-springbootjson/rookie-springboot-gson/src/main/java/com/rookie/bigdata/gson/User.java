package com.rookie.bigdata.gson;

import java.util.Date;

/**
 * @Class User
 * @Description
 * @Author rookie
 * @Date 2023/12/28 11:45
 * @Version 1.0
 */

public class User {

    private String name;
    private Date birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
