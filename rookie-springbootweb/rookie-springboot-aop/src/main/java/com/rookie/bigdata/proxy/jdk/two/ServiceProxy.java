//package com.rookie.bigdata.proxy.jdk.two;
//
//import sun.misc.ProxyGenerator;
//
//import java.io.FileOutputStream;
//import java.lang.reflect.Proxy;
//
///**
// * @Class ServiceProxy
// * @Description TODO
// * @Author rookie
// * @Date 2024/1/2 19:02
// * @Version 1.0
// */
//public class ServiceProxy {
//    public static void main(String[] args) {
//        IHello IHello = (IHello) getInstance(IHello.class, new ProxyHandler<>(new Hello()));
//
//        System.out.println(IHello.toString());
//
//        generateProxyClass();
//    }
//
//    // 创建代理对象
//    public static <T> Object getInstance(Class<T> clazz, ProxyHandler<T> handler) {
//
//        //Proxy#newProxyInstance() 方法是动态代理的入口，其生成动态代理对象主要有以下几个步骤：
//        //
//        //getProxyClass0() 方法生成代理类
//        //获取到代理类后将 InvocationHandler 对象入参，反射调用构造方法生成动态代理对象
//
//        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, handler);
//    }
//
//    private static void generateProxyClass() {
//        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Hello.class.getInterfaces());
//        String path = "C:\\work\\NewIDEAWorkSpace\\rookie-project\\github\\rookie-springboot\\rookie-springbootweb\\rookie-springboot-aopproxy\\src\\main\\java\\com\\rookie\\bigdata\\proxy\\jdk\\two\\StuProxy.class";
//        try (FileOutputStream fos = new FileOutputStream(path)) {
//            fos.write(classFile);
//            fos.flush();
//            System.out.println("代理类文件写入成功");
//        } catch (Exception e) {
//            System.out.println("写文件错误");
//        }
//    }
//}
