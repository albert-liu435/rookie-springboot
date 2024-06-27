package com.rookie.bigdata.annotation.custom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class UserFactoryTest
 * @Description
 * @Author rookie
 * @Date 2024/6/27 12:00
 * @Version 1.0
 */
class UserFactoryTest {


    @Test
    void create() {

        User user = UserFactory.create();
        user.setAge("30");
        System.out.println(user.getName());
        System.out.println(user.getAge());
    }

}
