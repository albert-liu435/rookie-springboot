package com.rookie.bigdata.exception;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 21:51
 * @Version 1.0
 */
public class NotFoundException extends RuntimeException{


    public NotFoundException(final String message) {
        super(message);
    }
}
