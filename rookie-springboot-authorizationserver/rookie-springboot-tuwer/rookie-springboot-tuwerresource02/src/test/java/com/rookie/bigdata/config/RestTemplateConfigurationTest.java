package com.rookie.bigdata.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class RestTemplateConfigurationTest
 * @Description
 * @Author rookie
 * @Date 2024/8/14 11:20
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@Slf4j
class RestTemplateConfigurationTest {

    @Autowired
    private RestTemplate restTemplate;


    @Test
    void test01() {

        // 对id及密钥加密
        byte[] userpass = Base64.encodeBase64(("micro_service:123456").getBytes(), false);
        String str = "";
        try {
            str = new String(userpass, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 请求头
        HttpHeaders headers1 = new HttpHeaders();
        // 组装请求头
        headers1.add("Authorization", "Basic " + str);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
//        formData.add("key1", "value1");
//        formData.add("key2", "value2");
        formData.add("grant_type", "client_credentials");

        formData.add("scope", "all");

        HttpEntity<MultiValueMap<String, String>> httpEntity1 = new HttpEntity<>(formData, headers1);



        // 响应体
        ResponseEntity<String> responseEntity1 = null;
        try {

            // 发起申请令牌请求
            responseEntity1 = restTemplate.postForEntity("http://rookie-tuwer.server.com:9000/oauth2/token", httpEntity1, String.class);
        } catch (RestClientException e) {

            log.error("令牌申请失败");
        }
    }


//    @Test
//    void test001() {
//        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
//        formData.add("key1", "value1");
//        formData.add("key2", "value2");
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
//    }
//
//    @Test
//    void test002() {
//        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
//        formData.add("key1", "value1");
//        formData.add("key2", "value2");
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
//    }
//
//    @Test
//    void test003() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        String formData = "key1=value1&key2=value2";
//        HttpEntity<String> requestEntity = new HttpEntity<>(formData, headers);
//
//        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
//    }


//    @Test
//    void test02(){
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
//                .addFormDataPart("grant_type","client_credentials")
//                .addFormDataPart("scope","all")
//                .build();
//        Request request = new Request.Builder()
//                .url("http://rookie-tuwer.server.com:9000/oauth2/token")
//                .method("POST", body)
//                .addHeader("Authorization", "Basic bWljcm9fc2VydmljZToxMjM0NTY=")
//                .build();
//        Response response = client.newCall(request).execute();
//    }

}
