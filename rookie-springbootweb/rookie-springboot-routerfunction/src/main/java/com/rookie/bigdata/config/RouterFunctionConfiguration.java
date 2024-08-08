package com.rookie.bigdata.config;

import com.rookie.bigdata.domain.User;
import com.rookie.bigdata.handler.UserHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.*;

import static org.springframework.web.servlet.function.RequestPredicates.GET;


/**
 * @Class RouterFunctionConfiguration
 * @Description
 * @Author rookie
 * @Date 2024/8/8 9:54
 * @Version 1.0
 */
@Configuration
@Slf4j
public class RouterFunctionConfiguration {


    @Autowired
    private UserHandler userHandler;


    @Bean
    public RouterFunction<ServerResponse> getModelBuildingRouters() {


        return RouterFunctions.route(GET("/model/hello"), request -> {
                    log.info("处理getModelBuildingRouters:{}", "hello getModelBuildingRouters");
                    return ServerResponse.ok().body("hello getModelBuildingRouters");
                })
                .andRoute(GET("/model/user"), request -> {
                    User user = new User();
                    user.setUsername("zhangsan");
                    log.info("处理getModelBuildingRouters:{}", "User");
                    return ServerResponse.ok().body(user);
//                    return ServerResponse.ok().body("hello test03");
                })
//                .andRoute(GET("/handler/user"), userHandler::getUserRespone)
                .andRoute(GET("/handler/user"), new HandlerFunction<ServerResponse>() {
                    @Override
                    public ServerResponse handle(ServerRequest request) throws Exception {
                        return userHandler.getUserRespone(request);
                    }
                })
                ;
    }


    @Bean
    public RouterFunction<ServerResponse> getModelBuildingRouters2() {
        return RouterFunctions.route(GET("/model2/hello"), request -> {
                    log.info("处理getModelBuildingRouters2:{}", "hello getModelBuildingRouters2");
                    return ServerResponse.ok().body("hello getModelBuildingRouters2");
                })
                .andRoute(GET("/model2/user"), request -> {
                    User user = new User();
                    user.setUsername("lisi");
                    log.info("处理getModelBuildingRouters2:{}", "User");
                    return ServerResponse.ok().body(user);
//                    return ServerResponse.ok().body("hello test03");
                })
                ;
    }
}
