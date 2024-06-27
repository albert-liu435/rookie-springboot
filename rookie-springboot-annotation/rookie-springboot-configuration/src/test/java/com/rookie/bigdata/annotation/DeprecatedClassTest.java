package com.rookie.bigdata.annotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class DeprecatedClassTest
 * @Description
 * @Author rookie
 * @Date 2024/6/27 10:54
 * @Version 1.0
 */
class DeprecatedClassTest {


    @Test
    void test01(){
        // 使用DeprecatedClass里声明被过时的方法
        DeprecatedClass.deprecatedMethod();
    }

}
