package com.rookie.bigdata.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 16:48
 * @Version 1.0
 */
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
@ActiveProfiles("dev")
class HomeControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void hello() {

        WebTestClient.ResponseSpec ok = webClient.post().uri("/controller")
                .contentType(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
        String responseBody = ok.expectBody(String.class).returnResult().getResponseBody();
        System.out.println("返回的数据为:"+responseBody);

    }
}