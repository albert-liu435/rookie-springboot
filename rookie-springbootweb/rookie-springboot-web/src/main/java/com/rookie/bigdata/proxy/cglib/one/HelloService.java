package com.rookie.bigdata.proxy.cglib.one;

/**
 * @Class HelloService
 * @Description
 * @Author rookie
 * @Date 2024/1/3 10:39
 * @Version 1.0
 */
public class HelloService {

    public HelloService() {
        System.out.println("HelloService构造");
    }

    /**
     * final方法不能被子类覆盖
     * Cglib 是无法代理 final 修饰的方法的
     */
    final public String sayOthers(String name) {
        System.out.println("HelloService:sayOthers>>"+name);
        return null;
    }

    public void sayHello() {
        System.out.println("HelloService:sayHello");
    }
}
