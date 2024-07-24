package com.rookie.bigdata.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * @ClassName UserControllerTest
 * @Description UserControllerTest
 * @Author rookie
 * @Date 2021/6/17 16:17
 * @Version 1.0
 */
@SpringBootTest
@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
class UserControllerTest {
    /**
     * 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * 注入WebApplicationContext
     */
    @Autowired
    private WebApplicationContext wac;

    @Test
    public void getUser2() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/event/getuser2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void getUser() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/event/getuser")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}
