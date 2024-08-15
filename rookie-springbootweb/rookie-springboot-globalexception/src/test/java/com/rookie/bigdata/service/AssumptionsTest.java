package com.rookie.bigdata.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * @ClassName AssumptionsTest
 * @Description AssumptionsTest
 * @Author rookie
 * @Date 2021/6/21 10:18
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("test")
public class AssumptionsTest {

    @Value("${type}")
    private String type;

    @Test
    @DisplayName("最普通的assume用法")
    void tryAssumeTrue() {
        //只有assumeTrue不抛出异常，后面的log.info才会执行
        assumeTrue("test".equals(type));


        System.out.println("test环境才会打印的assumeTrue");
    }

    @Test
    @DisplayName("assume失败时带自定义错误信息")
    void tryAssumeTrueWithMessage() {
        // assumeTrue可以接受Supplier类型作为第二个入参，如果assumeTrue失败就会将第二个参数的内容作为失败提示：
        assumeTrue("test".equals(type),
                () -> "环境不匹配而跳过，当前环境：" + type);

        System.out.println("test环境才会打印的tryAssumeTrueWithMessage");
    }

    /**
     * 还有个assumingThat方法，可以接受Executable类型作为第二个入参，如果第一个入参为true就会执行Executable的execute方法，注意assumingThat方法的特点：不抛出异常，
     * 因此其所在的方法不会被跳过，这是和assumeTrue相比最大的区别(assumeTrue一旦入参为false就会抛出异常，其所在方法就被标记为跳过)：
     */
    @Test
    @DisplayName("assume成功时执行指定逻辑")
    void tryAssumingThat() {
        // 第二个入参是Executable实现，
        // 当第一个参数为true时，执行第二个参数的execute方法
        assumingThat("test".equals(type),
                () -> {
                    System.out.println("这一行内容只有在test环境才会打印");
                });

        System.out.println("无论什么环境都会打印的tryAssumingThat");
    }

}
