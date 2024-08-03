package com.rookie.bigdata.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 10:55
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class StudentControllerTest {



    @Autowired
    MockMvc mockMvc;


    @Test
    void serialization() {
    }

    @Test
    void deserialization() {
    }
}