package com.rookie.bigdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.GET;

/**
 * @Class RouterFunctionConfiguration
 * @Description
 * @Author rookie
 * @Date 2024/8/8 9:54
 * @Version 1.0
 */
@Configuration
public class RouterFunctionConfiguration {


    @Bean
    public RouterFunction<ServerResponse> getModelBuildingRouters() {
        return RouterFunctions.route(GET("/model/hello"), request -> {
            return ServerResponse.ok().body("hello test03");
        });
    }
}
