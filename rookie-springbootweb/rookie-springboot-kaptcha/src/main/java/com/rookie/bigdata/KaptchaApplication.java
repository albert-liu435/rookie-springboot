package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * https://gitee.com/rwxing/springbootKaptcha
 * http://localhost:8080/kaptcha
 * <p>
 * <p>
 * http://localhost:8080/captcha/captchaImage?type=math
 * <p>
 * http://localhost:8080/hello?verifyCodeActual=5
 * <p>
 * <p>
 * http://localhost:8080/captcha/captchaImage?type=char
 * http://localhost:8080/hello?verifyCodeActual=5X23
 */
@SpringBootApplication
//@ImportResource(locations = {"classpath:kaptcha/kaptcha.xml"})
public class KaptchaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaptchaApplication.class, args);
    }
}
