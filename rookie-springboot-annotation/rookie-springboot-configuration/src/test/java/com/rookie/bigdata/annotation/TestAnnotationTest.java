package com.rookie.bigdata.annotation;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * @Class TestAnnotationTest
 * @Description
 * @Author rookie
 * @Date 2024/6/27 13:13
 * @Version 1.0
 */
@TestAnnotation(id = 222, msg = "awdawd")
class TestAnnotationTest {


    @Test
    void test01() {

        Method[] declaredMethods1 = TestAnnotation.class.getDeclaredMethods();
        for (Method meth : declaredMethods1) {
            System.out.println("注解的变量名为：" + meth.getName());
        }

        // 首先判断Test类上是否使用了TestAnnotation注解
        boolean hasAnnotation = TestAnnotationTest.class.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation) {
            // 获取注解,这个相当于是真正的拿到注解了，只有获取到这个才能获取到注解当中设置的值
            TestAnnotation testAnnotation = TestAnnotationTest.class.getAnnotation(TestAnnotation.class);
            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }
    }
}




