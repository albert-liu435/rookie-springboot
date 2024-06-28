package com.rookie.bigdata.listen;

import com.rookie.bigdata.event.SendEmailEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Class CustomListener
 * @Description 同步事件监听
 * @Author rookie
 * @Date 2023/3/16 18:33
 * @Version 1.0
 */
@Component
@Slf4j
public class CustomListener implements ApplicationListener<SendEmailEvent> {
    @Override
    public void onApplicationEvent(SendEmailEvent event) {
        send(event.getUser().getName());

        Object source = event.getSource();

    }
    public void send(String username) {
        String code = UUID.randomUUID().toString().replace("_", "").substring(0, 4);
        log.info("生成验证码: {}",code);
        // 可能由于网络带宽,发送验证码异常,模拟监听事件异常
//        int i = 1/0;
        log.info("【{}】本次登陆验证码为:{},请在5分钟内完成验证,请勿将验证码泄露给他人。",username,code);
    }
}
