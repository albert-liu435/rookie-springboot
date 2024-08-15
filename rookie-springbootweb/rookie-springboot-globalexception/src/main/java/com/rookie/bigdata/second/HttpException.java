package com.rookie.bigdata.second;

import lombok.Data;

/**
 * @Class HttpException
 * @Description  自定义一个异常类
 * @Author rookie
 * @Date 2024/8/15 10:30
 * @Version 1.0
 */
@Data
public class HttpException extends RuntimeException{

    //错误码
    private int code;

    //错误信息
    private String message;

    // 默认构造函数
    public HttpException() {
        super();
    }

    public HttpException(HttpStatusEnum httpStatusEnum) {
        super(String.valueOf(httpStatusEnum.getCode()));
        this.code = httpStatusEnum.getCode();
        this.message = httpStatusEnum.getMessage();
    }

}
