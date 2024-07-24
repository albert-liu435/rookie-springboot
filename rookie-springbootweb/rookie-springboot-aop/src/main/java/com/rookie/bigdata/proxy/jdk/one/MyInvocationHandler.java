package com.rookie.bigdata.proxy.jdk.one;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Class MyInvocationHandler
 * @Description
 * @Author rookie
 * @Date 2024/1/3 10:12
 * @Version 1.0
 */

// 为动态代理类关联一个自定义的 InvocationHandler
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 目标对象
     */
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    //重写invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------插入前置通知代码-------------");
        // 执行相应的目标方法
        Object rs = method.invoke(target, args);
        System.out.println("------插入后置处理代码-------------");
        return rs;
    }
}
