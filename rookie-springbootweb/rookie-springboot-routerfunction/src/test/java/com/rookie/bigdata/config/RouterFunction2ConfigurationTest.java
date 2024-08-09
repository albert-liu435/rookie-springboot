package com.rookie.bigdata.config;

import com.google.gson.Gson;
import com.rookie.bigdata.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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
                get("/handlerfunction/serverrequest/string?name=zhangsan")
                        .content("hello".getBytes(StandardCharsets.UTF_8)
                        ))
                        .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                        .andReturn();


//        System.out.println(mvcResult.getResponse());
        log.info("响应内容：{}", mvcResult.getResponse().getContentAsString());




    }

    @Test
    void serverrequestList() throws Exception {

        List<User> list=new ArrayList<>();
        User user=new User();
        user.setUsername("zhangsan");
        list.add(user);


        Class<RouterFunction2Configuration> routerFunction2ConfigurationClass = RouterFunction2Configuration.class;
        // 模拟
        MvcResult mvcResult = mvc.perform(
                        get("/handlerfunction/serverrequest/list")
//                                .content("hello".getBytes(StandardCharsets.UTF_8)
//                                )
                                //设置contentType参数
                                .contentType(MediaType.APPLICATION_JSON)
                                //设置请求体参数
                                .content(new Gson().toJson(list))
                )
                .andExpect(status().isOk())
//                .andExpect(content().string("Hello " + NAME))
                .andReturn();



//        System.out.println(mvcResult.getResponse());
        log.info("响应内容：{}", mvcResult.getResponse().getContentAsString());




    }


    @Test
    void getlHandlerFunctionServerResponseUser() throws Exception {

        List<User> list=new ArrayList<>();
        User user=new User();
        user.setUsername("zhangsan");
        list.add(user);


        Class<RouterFunction2Configuration> routerFunction2ConfigurationClass = RouterFunction2Configuration.class;
        // 模拟
        MvcResult mvcResult = mvc.perform(
                        get("/handlerfunction/serverresponse/user")
//                                .content("hello".getBytes(StandardCharsets.UTF_8)
//                                )
                                //设置contentType参数
                                .contentType(MediaType.APPLICATION_JSON)
                                //设置请求体参数
                                .content(new Gson().toJson(list))
                )
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
