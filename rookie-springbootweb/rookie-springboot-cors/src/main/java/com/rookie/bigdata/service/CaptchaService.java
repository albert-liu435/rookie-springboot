package com.rookie.bigdata.service;

import java.awt.image.BufferedImage;

/**
 * @ClassName CaptchaService
 * @Description CaptchaService
 * @Author rookie
 * @Date 2021/7/1 17:04
 * @Version 1.0
 */
public interface CaptchaService {
    /**
     * 获取图片验证码
     *
     * @param uuid
     * @return
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 校验验证码，在登录的时候进行校验
     *
     * @param uuid
     * @param code
     * @return
     */
    boolean validate(String uuid, String code);
}
