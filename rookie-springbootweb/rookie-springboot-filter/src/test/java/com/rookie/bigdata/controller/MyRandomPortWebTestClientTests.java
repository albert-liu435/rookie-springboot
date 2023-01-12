package com.rookie.bigdata.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @Classname MyRandomPortWebTestClientTests
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/12 17:54
 * @Version 1.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyRandomPortWebTestClientTests {

    @Test
    void exampleTest(@Autowired WebTestClient webClient) {
        webClient
                .get().uri("/getTrim?username=abc &phone=123456 ")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class);
    }

}