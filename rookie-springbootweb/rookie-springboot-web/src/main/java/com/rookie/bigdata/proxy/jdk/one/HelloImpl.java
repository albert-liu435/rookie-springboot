package com.rookie.bigdata.proxy.jdk.one;

/**
 * @Class HelloImpl
 * @Description
 * @Author rookie
 * @Date 2024/1/3 10:12
 * @Version 1.0
 */
//2.「服务类」
public class HelloImpl implements IHello {
    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }
}

