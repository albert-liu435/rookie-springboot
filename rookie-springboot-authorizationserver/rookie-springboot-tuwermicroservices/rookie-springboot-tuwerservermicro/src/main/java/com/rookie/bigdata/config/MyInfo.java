package com.rookie.bigdata.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Class MyInfo
 * @Description
 * @Author rookie
 * @Date 2024/8/14 13:52
 * @Version 1.0
 */
@Component
public class MyInfo implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        HashMap<String, Object> map = new HashMap<>();
        // 可以从数据库获取信息
        map.put("ServiceName","认证中心");
        map.put("version","1.0-SNAPSHOT");
        map.put("author","tuwer");
        builder.withDetails(map);
    }
}
