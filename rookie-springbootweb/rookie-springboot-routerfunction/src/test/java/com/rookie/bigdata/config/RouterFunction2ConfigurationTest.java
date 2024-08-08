package com.rookie.bigdata.config;

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
 * @Class RouterFunction2ConfigurationTest
 * @Description
 * @Author rookie
 * @Date 2024/8/8 17:49
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@Slf4j
class RouterFunction2ConfigurationTest {

    @Autowired
    MockMvc mvc;

    @Test
    void serverrequestString() throws Exception {
        Class<RouterFunction2Configuration> routerFunction2ConfigurationClass = RouterFunction2Configuration.class;
        // 模拟
        MvcResult mvcResult = mvc.perform(
                get("/router/function/handlerfunction/serverrequest/string?name=zhangsan")
                        .content("hello".getBytes(StandardCharsets.UTF_8)
                        ))
                        .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                        .andReturn();


//        System.out.println(mvcResult.getResponse());
        log.info("响应内容：{}", mvcResult.getResponse().getContentAsString());

    }

    @Test
    void getlBuildingRouters() {
    }
}
