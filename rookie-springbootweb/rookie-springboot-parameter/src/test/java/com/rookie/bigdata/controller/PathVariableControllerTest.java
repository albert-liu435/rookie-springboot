package com.rookie.bigdata.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Class PathVariableControllerTest
 * @Description
 * @Author rookie
 * @Date 2024/8/2 14:03
 * @Version 1.0
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class PathVariableControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void endpointApp() throws Exception {
        this.mvc.perform(get("/users/resource/jon"))
                .andExpect(status().isOk());
    }
}
