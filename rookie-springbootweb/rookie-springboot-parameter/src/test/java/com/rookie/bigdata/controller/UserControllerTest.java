package com.rookie.bigdata.controller;

import com.google.gson.Gson;
import com.rookie.bigdata.domain.User;
import com.rookie.bigdata.domain.UserStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Classname UserControllerTest
 * @Description TODO
 * @Author rookie
 * @Date 2021/8/18 9:47
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class UserControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @Test
    void addUser() throws Exception{

        User user=new User();
        user.setStatus("NORMAL");
        user.setNation("a");
        user.setStudentFlag(1);
        user.setName("qsm");


        System.out.println(new Gson().toJson(user));
        MvcResult result=mockMvc.perform(post("/users/add")
                .contentType(MediaType.APPLICATION_JSON)
                //设置请求体参数
                .content(new Gson().toJson(user)))
               // .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
}