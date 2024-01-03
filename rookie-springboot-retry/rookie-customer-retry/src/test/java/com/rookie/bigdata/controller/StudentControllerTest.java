//package com.rookie.bigdata.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * @ClassName StudentControllerTest
// * @Description StudentControllerTest
// * @Author rookie   通junit4类似
// * @Date 2021/6/21 10:42
// * @Version 1.0
// */
//@SpringBootTest
//@AutoConfigureMockMvc
//class StudentControllerTest {
//
//
//    private static final String NAME = "Tom";
//
//    @Test
//    void getHello(@Autowired MockMvc mvc) throws Exception {
//        // 模拟
//        MvcResult mvcResult = mvc.perform(get("/" + NAME))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
//                .andReturn();
//
//
//        System.out.println(mvcResult.getResponse());
//
//    }
//
//
//    void getHello() {
//
//    }
//}
