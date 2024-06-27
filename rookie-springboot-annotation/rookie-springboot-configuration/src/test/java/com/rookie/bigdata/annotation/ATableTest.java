package com.rookie.bigdata.annotation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Class ATableTest
 * @Description
 * @Author rookie
 * @Date 2024/6/27 11:47
 * @Version 1.0
 */
public class ATableTest {

//        public static void main(String[] args) {

    @Test
    void test01() {
        Class<Sub> clazz = Sub.class;
        System.out.println("============================AnnotatedElement===========================");
        // 获取自身和父级带有@Inherited修饰的注解。如果@ATable未加@Inherited修饰，则获取的只是自身的注解而无法获取父级修饰的@ATable注解
        System.out.println(Arrays.toString(clazz.getAnnotations()));
        System.out.println("------------------");
    }
}

@ATable
class Super {

}

@BTable
class Sub extends Super {
}

