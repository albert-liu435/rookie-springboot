//package com.rookie.bigdata.proxy.jdk;
//
//import org.junit.jupiter.api.Test;
//
//
///**
// * @Class UserDaoTest
// * @Description 动态代理
// * @Author rookie
// * @Date 2024/1/2 17:46
// * @Version 1.0
// */
//class UserDaoTest {
//
//
//    @Test
//    void testDynamicProxy() {
//        IUserDao target = new UserDao();
//        System.out.println(target.getClass());  //输出目标对象信息
//        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
//        System.out.println(proxy.getClass());  //输出代理对象信息
//        proxy.save();  //执行代理方法
//    }
//
//    @Test
//    void save() {
//    }
//}
