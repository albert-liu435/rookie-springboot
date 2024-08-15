package com.rookie.bigdata.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Classname TestControllerTest
 * @Description
 * @Author rookie
 * @Date 2023/1/16 9:19
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@Slf4j
class TestControllerTest {

//    @Autowired
//    MockMvc mvc;

    @Test
    void testGet(@Autowired MockMvc mvc) throws Exception{
        // 模拟
        MvcResult mvcResult = mvc.perform(get("/getById?id=8"))
                  .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                .andReturn();


        System.out.println(mvcResult.getResponse());
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void findAllUser(@Autowired MockMvc mvc) throws Exception{
        // 模拟
        MvcResult mvcResult = mvc.perform(get("/getById"))
                .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                .andReturn();


        System.out.println(mvcResult.getResponse());
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
