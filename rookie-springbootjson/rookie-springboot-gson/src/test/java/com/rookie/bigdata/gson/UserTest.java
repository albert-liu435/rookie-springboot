package com.rookie.bigdata.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class UserTest
 * @Description TODO
 * @Author rookie
 * @Date 2023/12/28 11:45
 * @Version 1.0
 */
class UserTest {


    @Test
    void test01(){
        Gson ignoreDateGson=new GsonBuilder().registerTypeAdapterFactory(new DateNullAdapterFactory<>()).create();
        Gson gson =new GsonBuilder().create();
        String  str = "{\"name\":\"张三\",\"birth\":\"\"}";
        User t1 = ignoreDateGson.fromJson(str, User.class);

        System.out.println(t1.getBirth());

		User t2 = gson.fromJson(str, User.class);

        System.out.println(t2.getBirth());
    }

}
