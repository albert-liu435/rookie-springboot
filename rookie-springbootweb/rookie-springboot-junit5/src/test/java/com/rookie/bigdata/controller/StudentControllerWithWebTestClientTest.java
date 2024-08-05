package com.rookie.bigdata.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @ClassName StudentControllerWithWebTestClientTest
 * @Description StudentControllerWithWebTestClientTest
 * @Author rookie
 * @Date 2021/6/21 10:47
 * @Version 1.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerWithWebTestClientTest {
    private static final String NAME = "Tom";

    @Test
    void hello(@Autowired WebTestClient webClient, @LocalServerPort int port) throws Exception {

        webClient
                .get()
                .uri("/" + NAME)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo("Hello " + NAME);

        System.out.println("web端口是: "+port);
    }
}

