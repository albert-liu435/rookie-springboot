package com.rookie.bigdata.service.impl;

import com.google.code.kaptcha.Producer;
import com.rookie.bigdata.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CaptchaServiceImpl
 * @Description CaptchaServiceImpl
 * @Author rookie
 * @Date 2021/7/1 17:06
 * @Version 1.0
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {


    private Map<String, String> map = new HashMap<>();

    @Autowired
    private Producer producer;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        //生成文字验证码
        String code = producer.createText();
        map.put(uuid, code);
        //生产环境该code存入数据库或者redis中，

        return producer.createImage(code);
    }

    @Override
    public boolean validate(String uuid, String code) {

        //生产环境可以添加过期时间的校验
        boolean flag= code.equals(map.get(uuid));
        return flag;
    }
}
