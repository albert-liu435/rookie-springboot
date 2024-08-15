package com.rookie.bigdata.second;

import com.rookie.bigdata.domain.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Class GlobalExceptionHandler
 * @Description
 * @Author rookie
 * @Date 2024/8/15 10:32
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //处理自定义异常
    @ExceptionHandler(value = HttpException.class)
    public HttpResult<Object> baseExceptionHandler(HttpException e) {
        log.error("发生业务异常！原因是：{}" , e.getMessage());
        return HttpResultGenerator.fail(e.getCode() , e.getMessage());
    }

    //处理空指针异常
    @ExceptionHandler(value = NullPointerException.class)
    public HttpResult<Object> exceptionHandler(Exception e) {
        log.error("发生异常！原因是：{}" , e);
        return HttpResultGenerator.fail(HttpStatusEnum.INTERNAM_SERVER_ERROR);
    }

}
