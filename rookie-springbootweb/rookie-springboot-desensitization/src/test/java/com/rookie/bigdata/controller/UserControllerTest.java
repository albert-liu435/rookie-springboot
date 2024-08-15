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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Class UserControllerTest
 * @Description
 * @Author rookie
 * @Date 2024/8/15 9:24
 * @Version 1.0
 */

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@Slf4j
class UserControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void getUser() throws Exception {
        // 模拟
        MvcResult mvcResult = mvc.perform(
                        get("/getUser3" )
                                .characterEncoding("UTF-8")
//                                .content("hello".getBytes(StandardCharsets.UTF_8))
                )

                .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                .andReturn();


//        System.out.println(mvcResult.getResponse());
        log.info("响应内容：{}", mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));


    }
}
