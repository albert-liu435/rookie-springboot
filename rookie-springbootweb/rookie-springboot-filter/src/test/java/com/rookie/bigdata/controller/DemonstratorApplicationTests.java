package com.rookie.bigdata.controller;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Classname DemonstratorApplicationTests
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/12 17:57
 * @Version 1.0
 */
@SpringBootTest
@AutoConfigureWebTestClient
public class DemonstratorApplicationTests {

//    private P4uServiceImpl p4uService = new P4uServiceImpl();
//
//    @Autowired
//    WebTestClient webTestClient;
//
//    @MockBean
//    ReqP4uAccount account;
//
//    @Test
//    void testPutAccount(){
//
//        ReqP4uAccount request = p4uService.buildRequest("testAccount");
//
//        this.webTestClient.put()
//                .uri("/account")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(request, ReqP4uAccount.class)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(P4uAccount.class);
//    }
}
