package com.rookie.bigdata.handler;

import com.rookie.bigdata.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @Class UserHandler
 * @Description
 * @Author rookie
 * @Date 2024/8/8 11:20
 * @Version 1.0
 */
@Component
@Slf4j
public class UserHandler {


    public ServerResponse getUserRespone(ServerRequest req) {
        User user = new User();
        user.setUsername("UserHandler");
        log.info("处理getModelBuildingRouters2:{}", "UserHandler");
        return ServerResponse.ok().body(user);
    }

}
