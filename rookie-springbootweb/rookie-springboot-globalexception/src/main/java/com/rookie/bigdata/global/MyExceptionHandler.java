//package com.rookie.bigdata.global;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * @Class MyExceptionHandler
// * @Description 全局处理异常方式1, 这种方式不太友好，所以基本使用全局处理异常方式2
// * @Author rookie
// * @Date 2024/8/15 10:20
// * @Version 1.0
// */
//@ControllerAdvice
//@Slf4j
//public class MyExceptionHandler {
//
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public String exceptionHandler(Exception e) {
////        System.out.println("全局异常捕获>>>:" + e);
//        log.error("全局异常捕获", e);
//        return "全局异常捕获,错误原因>>>" + e.getMessage();
//    }
//}
//
