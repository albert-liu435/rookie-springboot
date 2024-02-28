package com.rookie.bigdata.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Class UserControllerTest
 * @Description
 * @Author rookie
 * @Date 2024/2/28 15:10
 * @Version 1.0
 */

@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("dev")
class UserControllerTest {

//    @BeforeEach
//    void before(WebApplicationContext context) {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context)
//                .addFilter((request, response, chain) -> {
//                    response.setCharacterEncoding("UTF-8");
//                    chain.doFilter(request, response);
//                }, "/*")
//                .build();
//    }


    @Test
    void getUser(@Autowired MockMvc mvc) throws Exception {

//        String url = "/searchMemberInfo?uId=&name=";
//        String result = mockMvc.perform(MockMvcRequestBuilders.get(url)
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andReturn()
//                .getResponse()
//                .getContentAsString(StandardCharsets.UTF_8);
//        log.info("返回结果 =>{}", result);


        // 模拟
        MvcResult mvcResult = mvc.perform(get("/getuser"))
                .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                .andReturn();


        System.out.println(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    void getUser1(@Autowired MockMvc mvc) throws Exception {
        // 模拟
        MvcResult mvcResult = mvc.perform(get("/getuser1"))
                .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                .andReturn();


        System.out.println(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }
    @Test
    void getUser2(@Autowired MockMvc mvc) throws Exception {
        // 模拟
        MvcResult mvcResult = mvc.perform(get("/getuser2"))
                .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                .andReturn();


        System.out.println(mvcResult.getResponse());

    }
    @Test
    void getUser3(@Autowired MockMvc mvc) throws Exception {
        // 模拟
        MvcResult mvcResult = mvc.perform(get("/getuser3"))
                .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                .andReturn();


        System.out.println(mvcResult.getResponse());

    }

}
