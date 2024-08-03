//package com.rookie.bigdata.controller;
//
//import com.rookie.bigdata.domain.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import reactor.core.publisher.Mono;
//
//import java.nio.charset.StandardCharsets;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * @Author rookie
// * @Description
// * @Date 2024/8/3 16:48
// * @Version 1.0
// */
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////@AutoConfigureMockMvc
//@ActiveProfiles("dev")
//class HomeControllerTest {
//
//    @Autowired
//    private WebTestClient webClient;
//
//    @Test
//    void hello() {
//
//        WebTestClient.ResponseSpec ok = webClient.post().uri("/hello")
//                .contentType(MediaType.APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isOk();
//        String responseBody = ok.expectBody(String.class).returnResult().getResponseBody();
//        System.out.println("返回的数据为:"+responseBody);
//
//    }
//
//    @Test
//    void testUser(){
//
//        User user=new User();
//        user.setName("张三");
//
//        WebTestClient.ResponseSpec ok = webClient.post().uri("/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(Mono.just(user),User.class)
//                .exchange()
//                .expectStatus().isOk();
////        String responseBody = ok.expectBody(String.class).returnResult().getResponseBody();
//        byte[]  responseBody1= ok.expectBody().returnResult().getResponseBody();
//
//        System.out.println("返回的数据为:"+new String(responseBody1, StandardCharsets.UTF_8));
//    }
//
//}