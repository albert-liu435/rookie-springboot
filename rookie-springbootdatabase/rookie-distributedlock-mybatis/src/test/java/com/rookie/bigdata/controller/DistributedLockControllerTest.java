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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @Class DistributedLockControllerTest
 * @Description
 * @Author rookie
 * @Date 2024/8/15 11:01
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@Slf4j
class DistributedLockControllerTest {


    @Autowired
    MockMvc mvc;

    @Test
    void testLock() throws Exception {

        //        String url = "/searchMemberInfo?uId=&name=";
//        String result = mockMvc.perform(MockMvcRequestBuilders.get(url)
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andReturn()
//                .getResponse()
//                .getContentAsString(StandardCharsets.UTF_8);
//        log.info("返回结果 =>{}", result);


        // 模拟
        MvcResult mvcResult = mvc.perform(get("/mysqlLock"))
                .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                .andReturn();


        System.out.println(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
