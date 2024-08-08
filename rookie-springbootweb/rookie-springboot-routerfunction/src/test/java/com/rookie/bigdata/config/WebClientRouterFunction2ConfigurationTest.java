package com.rookie.bigdata.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Class WebClientRouterFunction2ConfigurationTest
 * @Description
 * @Author rookie
 * @Date 2024/8/8 18:00
 * @Version 1.0
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
//@AutoConfigureMockMvc
@Slf4j
public class WebClientRouterFunction2ConfigurationTest {


//    @Autowired
//    WebTestClient webClient;
//    @LocalServerPort
//    int port;

    @Test
    void serverrequestString1(@Autowired WebTestClient webClient, @LocalServerPort int port) throws Exception {
        Class<RouterFunction2Configuration> routerFunction2ConfigurationClass = RouterFunction2Configuration.class;
//        // 模拟
//        MvcResult mvcResult = mvc.perform(
//                        get("/router/function/handlerfunction/serverrequest/string")
//                                .content("hello".getBytes(StandardCharsets.UTF_8)
//                                ))
//                .andExpect(status().isOk())
////                .andExpect(content().string("Hello " + NAME))
//                .andReturn();

//        webClient.get().uri("/handlerfunction/serverrequest/string?name=zhangsan").accept(MediaType.ALL).

//        WebTestClient.ResponseSpec hello = webClient.method(HttpMethod.GET).bodyValue("hello").exchange().expectStatus().isOk();

        WebTestClient.BodySpec<String, ?> stringBodySpec = webClient
                .get()
                .uri("/handlerfunction/serverrequest/string?name=zhangsan")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class);

//                .isEqualTo("Hello " + NAME);

//        System.out.println("web端口是: "+port);
        String responseBody = stringBodySpec.returnResult().getResponseBody();

//        System.out.println(mvcResult.getResponse());
        log.info("响应内容：{}", responseBody);

    }

}
