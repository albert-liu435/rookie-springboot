package com.rookie.bigdata.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description User
 * @Author rookie
 * @Date 2021/6/17 9:33
 * @Version 1.0
 */
@Data
public class User implements Serializable {

    private long id;

    private String username;

    private int type;



}
