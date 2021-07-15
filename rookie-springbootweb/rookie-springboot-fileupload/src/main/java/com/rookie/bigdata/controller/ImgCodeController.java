package com.rookie.bigdata.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname ImgCodeController
 * @Description 用于生成验证码
 * @Author rookie
 * @Date 2021/7/14 15:57
 * @Version 1.0
 */
@RestController
@RequestMapping("image")
public class ImgCodeController {


    /**
     * 生成图片验证码
     *
     * @param request
     * @param response
     */
    @RequestMapping("/getImage")
    public void ImgCode(HttpServletRequest request, HttpServletResponse response) {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

        try {
            String code = lineCaptcha.getCode();
            //可以将code保存到redis中，然后在验证的时候进行使用
            System.out.println(code);
            request.getSession().setAttribute("CAPTCHA_KEY",code );
            response.setContentType("image/png");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            lineCaptcha.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    /**
//     * 对验证码进行输入验证
//     * @param vername
//     * @return
//     */
//    @RequestMapping(value = "/getverfy",method = RequestMethod.POST)
//    public @ResponseBody JSONObject verfy(String vername){
//        JSONObject json =new JSONObject();
//        if(lineCaptcha.verify(vername)){
//            json.put("Verfystatus","Correct");
//        }else {
//            json.put("Verfystatus","Wrong");
//        }
//        return json;
//    }


}
