package com.rookie.bigdata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @Class ResourceController
 * @Description TODO
 * @Author rookie
 * @Date 2024/8/13 18:26
 * @Version 1.0
 */
@Slf4j
@RestController
public class ResourceController {
    @Autowired
    RestTemplate restTemplate;

    private String BASE_URL = "http://rookie-tuwer.gateway.com:9999";

    @GetMapping("/server/a/res1")
    public String getServerARes1(@RegisteredOAuth2AuthorizedClient
                                 OAuth2AuthorizedClient oAuth2AuthorizedClient) {
        return getServer(BASE_URL + "/o2_resource_a/res1", oAuth2AuthorizedClient);
    }

    @GetMapping("/server/a/res2")
    public String getServerARes2(@RegisteredOAuth2AuthorizedClient
                                 OAuth2AuthorizedClient oAuth2AuthorizedClient) {
        return getServer(BASE_URL + "/o2_resource_a/res2", oAuth2AuthorizedClient);
    }

    @GetMapping("/server/b/res1")
    public String getServerBRes1(@RegisteredOAuth2AuthorizedClient
                                 OAuth2AuthorizedClient oAuth2AuthorizedClient) {
        return getServer(BASE_URL + "/o2_resource_b/res1", oAuth2AuthorizedClient);
    }

    @GetMapping("/server/b/res2")
    public String getServerBRes2(@RegisteredOAuth2AuthorizedClient
                                 OAuth2AuthorizedClient oAuth2AuthorizedClient) {
        return getServer(BASE_URL + "/o2_resource_b/res2", oAuth2AuthorizedClient);
    }

/*    @GetMapping("/getRole")
    public String getRole(@RegisteredOAuth2AuthorizedClient
                                      OAuth2AuthorizedClient oAuth2AuthorizedClient){
        log.info("进入getRole");
        //String username = "test";
        //String roles = restTemplate.getForObject("http://os.com:9000/oauth2/getRole/"+username, String.class);
        return getServer("http://os.com:9000/oauth2/user", oAuth2AuthorizedClient);
    }*/

    /**
     * 绑定token，请求微服务
     *
     * @param url
     * @param oAuth2AuthorizedClient
     * @return
     */
    private String getServer(String url, OAuth2AuthorizedClient oAuth2AuthorizedClient) {
        log.info("进入getServer方法");
        // 获取 token
        String tokenValue = oAuth2AuthorizedClient.getAccessToken().getTokenValue();

        // 请求头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + tokenValue);
        // 请求体
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        // 发起请求
        ResponseEntity<String> responseEntity;
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        } catch (RestClientException e) {
            // e.getMessage() 信息格式：
            // 403 : "{"msg":"拒绝访问","uri":"/res2"}"
            // 解析，取出消息体 {"msg":"拒绝访问","uri":"/res2"}
            String str = e.getMessage();
            // 取两个括号中间的部分（包含两个括号）
            return str.substring(str.indexOf("{"), str.indexOf("}") + 1);
        }
        // 返回
        return responseEntity.getBody();
    }


    /**
     * 绑定token，请求微服务
     *
     * @param url
     * @param oAuth2AuthorizedClient
     * @return
     */
//    private String getServer(String url, OAuth2AuthorizedClient oAuth2AuthorizedClient) {
//        // 获取 token
//        String tokenValue = oAuth2AuthorizedClient.getAccessToken().getTokenValue();
//
//        // 请求头
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer " + tokenValue);
//        // 请求体
//        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
//        // 发起请求
//        ResponseEntity<String> responseEntity;
//        try {
//            responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
//        } catch (RestClientException e) {
//            // e.getMessage() 信息格式：
//            // 403 : "{"msg":"拒绝访问","uri":"/res2"}"
//            // 解析，取出消息体 {"msg":"拒绝访问","uri":"/res2"}
//            String str = e.getMessage();
//            // 取两个括号中间的部分（包含两个括号）
//            return str.substring(str.indexOf("{"), str.indexOf("}") + 1);
//        }
//        // 返回
//        return responseEntity.getBody();
//    }
}
