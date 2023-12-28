package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.service.StudentService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName StudentServiceImplTest
 * @Description StudentServiceImplTest
 * @Author rookie
 * @Date 2021/6/21 9:53
 * @Version 1.0
 */
@SpringBootTest
class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;


    /**
     * 在所有测试方法执行前被执行
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("execute beforeAll");
    }

    /**
     * 在所有测试方法执行后被执行
     */
    @AfterAll
    static void afterAll() {
        System.out.println("execute afterAll");
    }

    /**
     * 每个测试方法执行前都会执行一次
     */
    @BeforeEach
    void beforeEach() {
        System.out.println("execute beforeEach");
    }

    /**
     * 每个测试方法执行后都会执行一次
     */
    @AfterEach
    void afterEach() {
        System.out.println("execute afterEach");
    }


    @Test
    @DisplayName("测试service层的hello方法")
    void hello() {
        System.out.println("execute hello");
    }

    /**
     * DisplayName中带有emoji，在测试框架中能够展示
     */
    @Test
    @DisplayName("测试service increase")
    void increase() {
        System.out.println("increase");

    }

    /**
     * 不会被执行的测试方法
     */
    @Test
    @Disabled
    void neverExecute() {

        System.out.println("不会被执行的测试方法");
    }

    /**
     * 调用一个耗时1秒的方法，用Timeout设置超时时间是500毫秒，
     * 因此该用例会测试失败
     */
    @Test
    @Timeout(unit = TimeUnit.MILLISECONDS, value = 500)
    void remoteRequest() throws Exception{

        Thread.sleep(100000);
    }


    @Test
    void getUser() {
    }
}