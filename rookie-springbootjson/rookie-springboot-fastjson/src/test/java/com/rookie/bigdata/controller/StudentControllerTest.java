package com.rookie.bigdata.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
    void serialization() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/serialization")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void deserialization() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/deserialization")
                        .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                                "\t\"age\":23,\n" +
                                "\t\"birthDate\":\"2021-06-17\",\n" +
                                "\t\"id\":100,\n" +
                                "\t\"name\":\"zhagnsan\",\n" +
                                "\t\"studentNo\":10\n" +
                                "}\n"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }
}