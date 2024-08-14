package com.rookie.bigdata.controller;

import com.alibaba.fastjson2.JSON;
import com.rookie.bigdata.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Class ResourceController
 * @Description
 * @Author rookie
 * @Date 2024/8/13 15:14
 * @Version 1.0
 */
@RestController
@Slf4j
public class ResourceController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/res1")
    public String getRes1(HttpServletRequest request) {
        return getServer("http://127.0.0.1:8001/res2", request);
        //return JSON.toJSONString(new Result(200, "服务B -> 资源1"));
    }

    @GetMapping("/res2")
    public String getRes2() {
        return JSON.toJSONString(new Result(200, "服务B -> 资源2"));
    }

    /**
     * 请求资源
     *
     * @param url
     * @param request
     * @return
     */
    private String getServer(String url,
                             HttpServletRequest request) {
        // ======== 1、从session中取token ========
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("micro-token");

        // ======== 2、请求token ========
        // 先查session中是否有token；session中没有
        if (StringUtils.isEmpty(token)) {
            // ===== 去认证中心申请 =====
            // 对id及密钥加密
            byte[] userpass = Base64.encodeBase64(("micro_service:123456").getBytes(), false);
            String str = "";
            try {
                str = new String(userpass, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

//            // 对id及密钥加密
//            byte[] userpass = Base64.encodeBase64(("micro_service:123456").getBytes(), false);
//            String str = "";
//            try {
//                str = new String(userpass, "UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }

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

            // 令牌申请成功
            if (responseEntity1 != null) {
                // 解析令牌
                //String t = JSON.parseObject(responseEntity1.getBody(), MyAuth.class).getAccess_token();
                Map<String, String> resMap = JSON.parseObject(responseEntity1.getBody(), HashMap.class);
                String t = resMap.get("access_token");
                // 存入session
                session.setAttribute("micro-token", t);
                // 赋于token变量
                token = t;
                log.info("令牌申请成功");
            }
        }

        // ======== 3、请求资源 ========
        // 请求头
        HttpHeaders headers2 = new HttpHeaders();
        // 组装请求头
        headers2.add("Authorization", "Bearer " + token);
        // 请求体
        HttpEntity<Object> httpEntity2 = new HttpEntity<>(headers2);
        // 响应体
        ResponseEntity<String> responseEntity2;
        try {
            // 发起访问资源请求
            responseEntity2 = restTemplate.exchange(url, HttpMethod.GET, httpEntity2, String.class);
        } catch (RestClientException e) {
            // 令牌失效(认证失效401) --> 清除session
            // e.getMessage() 信息格式：
            // 401 : "{"msg":"认证失败","uri":"/res2"}"
            String str = e.getMessage();
            // 判断是否含有 401
            if (StringUtils.contains(str, "401")) {
                // 如果有401，把session中 micro-token 的值设为空
                session.setAttribute("micro-token", "");
            }
            // 取两个括号中间的部分（包含两个括号）
            return str.substring(str.indexOf("{"), str.indexOf("}") + 1);
        }
        // 返回
        return responseEntity2.getBody();
    }
}

/*@Data
class MyAuth {
    private String access_token;
    private String scope;
    private String token_type;
    private long expires_in;
}*/
