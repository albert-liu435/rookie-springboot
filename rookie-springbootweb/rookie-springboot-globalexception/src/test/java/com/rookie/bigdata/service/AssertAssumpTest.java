package com.rookie.bigdata.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Assertions即断言类，里面提供了很多静态方法，例如assertTrue，如果assertTrue的入参为false，就会抛出AssertionFailedError异常，Junit对抛出此异常的方法判定为失败；
 * Assumptions即假设类，里面提供了很多静态方法，例如assumeTrue，如果assumeTrue的入参为false，就会抛出TestAbortedException异常，Junit对抛出此异常的方法判定为跳过；
 * 简单的说，Assertions的方法抛出异常意味着测试不通过，Assumptions的方法抛出异常意味着测试被跳过(为什么称为"跳过"？因为mvn test的执行结果被标记为Skipped)；
 *
 *
 *
 * @ClassName AssertAssumpTest
 * @Description AssertAssumpTest
 * @Author rookie
 * @Date 2021/6/21 10:09
 * @Version 1.0
 */
@SpringBootTest
public class AssertAssumpTest {

    @Test
    void assertSuccess() {
        assertEquals(2, Math.addExact(1,1));
    }

    /**
     * 最简单的失败用例
     */
    @Test
    void assertFail() {
        assertEquals(3, Math.addExact(1,1));
    }

    /**
     * assumeTrue不抛出异常的用例
     */
    @Test
    void assumpSuccess() {
        // assumeTrue方法的入参如果为true，就不会抛出异常，后面的代码才会继续执行
        assumeTrue(true);
        // 如果打印出此日志，证明assumeTrue方法没有抛出异常
        System.out.println("assumpSuccess的assumeTrue执行完成");
        // 接下来是常规的单元测试逻辑
        assertEquals(2, Math.addExact(1,1));
    }

    /**
     * assumeTrue抛出异常的用例
     */
    @Test
    void assumpFail() {
        // assumeTrue方法的入参如果为false，就会抛出TestAbortedException异常，后面就不会执行了
        assumeTrue(false, "未通过assumeTrue");
        // 如果打印出此日志，证明assumpFail方法没有抛出异常
        System.out.println("assumpFail的assumeTrue执行完成");
        // 接下来是常规的单元测试逻辑，但因为前面抛出了异常，就不再执行了
        assertEquals(2, Math.addExact(1,1));
    }
}
