package com.rookie.bigdata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rookie.bigdata.domain.Student;
import com.rookie.bigdata.service.CaptchaService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName StudentController
 * @Description StudentController
 * @Author rookie
 * @Date 2021/6/18 10:25
 * @Version 1.0
 */

@RestController
public class StudentController {

    @Autowired
    private CaptchaService captchaService;


    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(value = "/serialization", method = RequestMethod.GET)
    public Student serialization() throws JsonProcessingException {

        Student student = new Student();
        student.setId(100L);
        student.setName("zhagnsan");
        student.setAge(23);
        student.setStudentNo(10);
        student.setBirthDate(new Date());

        System.out.println(mapper.writeValueAsString(student));

        return student;
    }


    @RequestMapping(value = "/deserialization", method = RequestMethod.PUT)
    public String deserialization(@RequestBody Student student) {
        return student.toString();
    }


    /**
     * 采用postman调用该方法获取验证码
     * 获取图片校验码
     *
     * @param response
     * @param uuid
     * @throws IOException
     */
    @GetMapping("/captcha")
    public void captcha(HttpServletResponse response, String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");


        //获取图片验证码
        BufferedImage image = captchaService.getCaptcha(uuid);

        try (//try-with-resources 语法，自动关闭资源
             ServletOutputStream out = response.getOutputStream()
        ) {
            ImageIO.write(image, "jpg", out);
        }
    }
}
