package com.rookie.bigdata.proxy.jdk.two;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Class ProxyHandler
 * @Description
 * @Author rookie
 * @Date 2024/1/2 19:01
 * @Version 1.0
 */
public class ProxyHandler<T> implements InvocationHandler {
    private T origin;

    public ProxyHandler(T origin) {
        this.origin = origin;
    }

    /**
     * @param o       代理对象引用
     * @param method  正在执行目标的方法
     * @param objects 目标方法执行时的入参
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        String s = "proxy";
        s += method.invoke(origin, objects);
        return s;
    }
}
