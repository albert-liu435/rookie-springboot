package com.rookie.bigdata.annotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Class RepeatableTest
 * @Description
 * @Author rookie
 * @Date 2024/6/27 11:52
 * @Version 1.0
 */
class RepeatableTest {


    @Value("hello")
    @Value("world")
    public void test(String var1, String var2) {
        System.out.println(var1 + " " + var2);
    }

//        public static void main(String[] args) {

    @Test
    void test01() {
        Method[] methods = RepeatableTest.class.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("test")) {
                Annotation[] annotations = method.getDeclaredAnnotations();
                System.out.println(annotations.length);
                System.out.println(method.getName() + " = " + Arrays.toString(annotations));

            }
        }
    }
}
