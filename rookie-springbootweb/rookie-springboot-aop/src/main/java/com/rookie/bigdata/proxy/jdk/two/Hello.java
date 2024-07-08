package com.rookie.bigdata.proxy.jdk.two;

/**
 * @Class Hello
 * @Description TODO
 * @Author rookie
 * @Date 2024/1/2 19:01
 * @Version 1.0
 */
public class Hello implements IHello {
    @Override
    public String sayHi() {
        return "Hello";
    }
}
