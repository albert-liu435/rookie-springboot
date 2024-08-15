package com.rookie.bigdata.domain;

import lombok.Data;

/**
 * @Class HttpResult
 * @Description http 统一返回类
 * @Author rookie
 * @Date 2024/8/15 10:31
 * @Version 1.0
 */
@Data
public class HttpResult<T> {

    private Integer code;

    private String message;

    private T data;

    //构造方法
    public HttpResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //默认构造函数
    public HttpResult() {
        super();
    }
}

