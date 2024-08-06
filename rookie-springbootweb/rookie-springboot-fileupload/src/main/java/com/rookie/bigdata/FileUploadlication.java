package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * https://www.hangge.com/blog/cache/detail_2462.html
 * <p>
 * https://www.hangge.com/blog/cache/detail_2463.html
 *
 * @ClassName Application
 * @Description Application  http://localhost:8083/upload.html
 * @Author rookie
 * @Date 2020/8/7 11:21
 * @Version 1.0
 */
@SpringBootApplication
public class FileUploadlication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(FileUploadlication.class);
        springApplication.run(args);

    }
}
