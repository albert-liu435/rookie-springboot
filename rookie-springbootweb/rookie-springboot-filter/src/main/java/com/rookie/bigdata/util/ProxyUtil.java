package com.rookie.bigdata.util;

import cn.hutool.core.io.IoUtil;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @Class ProxyUtil
 * @Description https://blog.oldwu.top/index.php/archives/144/
 * @Author rookie
 * @Date 2024/7/24 13:27
 * @Version 1.0
 */
public class ProxyUtil {


    protected static final Logger logger = LoggerFactory.getLogger(ProxyUtil.class);


    public static void proxy(URI newUri, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String methodName = request.getMethod();
        HttpMethod httpMethod = HttpMethod.valueOf(methodName);
        if (httpMethod == null) {
            return;
        }
        ClientHttpRequest delegate = new SimpleClientHttpRequestFactory().createRequest(newUri, httpMethod);
        Enumeration<String> headerNames = request.getHeaderNames();
        // 设置请求头
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> v = request.getHeaders(headerName);
            List<String> arr = new ArrayList<>();
            while (v.hasMoreElements()) {
                arr.add(v.nextElement());
            }
            delegate.getHeaders().addAll(headerName, arr);
        }
        StreamUtils.copy(request.getInputStream(), delegate.getBody());
        // 执行远程调用
        ClientHttpResponse clientHttpResponse = delegate.execute();
        response.setStatus(clientHttpResponse.getStatusCode().value());
        // 设置响应头
        clientHttpResponse.getHeaders().forEach((key, value) -> value.forEach(it -> {
            response.setHeader(key, it);
        }));

//        InputStream body = clientHttpResponse.getBody();

//        InputStream body = clientHttpResponse.getBody();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        IOUtils.copy(clientHttpResponse.getBody(), baos);
        byte[] requestBody = baos.toByteArray();


      String str=new String(requestBody,StandardCharsets.UTF_8);

        logger.info("请求完成："+str);
        StreamUtils.copy(requestBody, response.getOutputStream());



//        InputStream body = clientHttpResponse.getBody();
//
//        ServletOutputStream outputStream = response.getOutputStream();
//
//
//        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//        byte[] buffer=new byte[1024];
//        int len;
//        while ((len=outputStream.))
//
//
//
////        InputStream body=new ByteArrayInputStream(1024*100);
//
////        IoUtil.copy(outputStream,)
////        String s1 = StreamUtils.copyToString(outputStream, StandardCharsets.UTF_8);
//
//        String s = StreamUtils.copyToString(body, StandardCharsets.UTF_8);
//
//        logger.info("请求完成："+s);

    }



}
