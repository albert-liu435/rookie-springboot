package com.rookie.bigdata.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Classname RequestUtils
 * @Description
 * @Author rookie
 * @Date 2021/9/16 17:27
 * @Version 1.0
 */
public class RequestUtils {


    /**
     * 获取请求体json字符串
     * */
    public static String getJsonBody(HttpServletRequest request){
        String param= null;
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
            //BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream()));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            param = responseStrBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return param;
    }


    public static String getJsonBody(){
        //获取请求体消息
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        //String s = IoUtil.readUtf8(request.getInputStream());
        return getJsonBody(request);


    }

}
