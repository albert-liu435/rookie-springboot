package com.rookie.bigdata.annotation.jsoninclude;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import lombok.Data;

/**
 * @ClassName User
 * @Description User
 * @Author rookie   https://blog.csdn.net/boling_cavalry/article/details/108460433
 * @Date 2021/6/17 10:39
 * @Version 1.0
 */
@Data
//默认策略，任何情况都执行序列化
//@JsonInclude(JsonInclude.Include.ALWAYS)
//null值不会执行序列化
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private long id;

    private String username;

    private String address;

    private String degree;

    private int type;


    public static void main(String[] args)  throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        // 美化输出
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // jackson支持Optional特性
        mapper.registerModule(new Jdk8Module());

        User user = new User();
        user.setUsername("zhangsan");
        user.setAddress("");
        user.setDegree(null);


        System.out.println(mapper.writeValueAsString(user));
    }

}
