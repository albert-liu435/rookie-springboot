package com.rookie.bigdata.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Class MyException
 * @Description
 * @Author rookie
 * @Date 2023/12/28 16:43
 * @Version 1.0
 */
@Getter
@Setter
public class MyException extends Exception {
    private String myMessage;

    public MyException(String myMessage) {
        this.myMessage = myMessage;
    }
}
