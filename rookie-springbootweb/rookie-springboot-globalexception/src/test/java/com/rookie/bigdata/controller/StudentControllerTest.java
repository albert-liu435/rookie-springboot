package com.rookie.bigdata.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ClassName StudentControllerTest
 * @Description StudentControllerTest
 * @Author rookie   同junit4类似
 * @Date 2021/6/21 10:42
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@Slf4j
class StudentControllerTest {


    @Autowired
    MockMvc mvc;

    private static final String NAME = "Tom";

    @Test
    void getHello() throws Exception {
        // 模拟
        MvcResult mvcResult = mvc.perform(
                        get("/" + NAME)
                                .content("hello".getBytes(StandardCharsets.UTF_8))
                )

                .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                .andReturn();


//        System.out.println(mvcResult.getResponse());
        log.info("响应内容：{}", mvcResult.getResponse().getContentAsString());

    }

    @Test
    void getUser() throws Exception {

        // 模拟
        MvcResult mvcResult = mvc.perform(
                        get("/getuser")
//                                .content("hello".getBytes(StandardCharsets.UTF_8))
                )

                .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                .andReturn();


//        System.out.println(mvcResult.getResponse());
        log.info("响应内容：{}", mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }


    @Test
    void getUserSecond()throws Exception{
        // 模拟
        MvcResult mvcResult = mvc.perform(
                        get("/getUserSecond")
//                                .content("hello".getBytes(StandardCharsets.UTF_8))
                )

                .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                .andReturn();


//        System.out.println(mvcResult.getResponse());
        log.info("响应内容：{}", mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }
}
