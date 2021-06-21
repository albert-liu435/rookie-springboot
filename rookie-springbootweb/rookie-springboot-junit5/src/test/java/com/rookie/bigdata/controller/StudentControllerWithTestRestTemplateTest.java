package com.rookie.bigdata.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @ClassName StudentControllerWithTestRestTemplateTest
 * @Description StudentControllerWithTestRestTemplateTest
 * @Author rookie
 * @Date 2021/6/21 10:45
 * @Version 1.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerWithTestRestTemplateTest {

    private static final String NAME = "Tom";

    @Test
    void hello(@Autowired TestRestTemplate testRestTemplate, @LocalServerPort int port) throws Exception {
        System.out.println("web端口是: "+port);

        // 向web server发送请求
        ResponseEntity responseEntity = testRestTemplate.exchange("/" + NAME, HttpMethod.GET, HttpEntity.EMPTY, String.class);
        // 检查code
        assertThat(responseEntity.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        // 检查内容
        assertThat(responseEntity.getBody()).isEqualTo("Hello " + NAME);
    }
}
