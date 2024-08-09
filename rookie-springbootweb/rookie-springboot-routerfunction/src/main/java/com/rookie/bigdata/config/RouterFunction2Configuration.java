package com.rookie.bigdata.config;

import com.rookie.bigdata.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.function.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.servlet.function.RequestPredicates.GET;

/**
 * @Class RouterFunction2Configuration
 * @Description
 * @Author rookie
 * @Date 2024/8/8 17:37
 * @Version 1.0
 */
@Configuration
@Slf4j
public class RouterFunction2Configuration {

    /**
     * HandlerFunction.ServerRequest
     *
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> getlHandlerFunctionServerRequest() {

        RouterFunction<ServerResponse> routerFunction = RouterFunctions
                .route(GET("/handlerfunction/serverrequest/string"), request -> {
                    String body = request.body(String.class);
                    Optional<String> name = request.param("name");
                    log.info("获取请求的body {},name {}", body, name.get());
                    return ServerResponse.ok().body(name.get());
                })
                .andRoute(GET("/handlerfunction/serverrequest/list"), request -> {
                    List<User> userList = request.body(new ParameterizedTypeReference<List<User>>() {
                    });
                    return ServerResponse.ok().body(userList);
                })
                .andRoute(GET("/handlerfunction/serverrequest/params"), request -> {
                    MultiValueMap<String, String> params = request.params();
                    return ServerResponse.ok().body(params);
                });

        return routerFunction;
    }

    /**
     * HandlerFunction.ServerResponse
     *
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> getlHandlerFunctionServerResponse() {

        RouterFunction<ServerResponse> routerFunction = RouterFunctions
                .route(GET("/handlerfunction/serverresponse/user"), request -> {
//                    String body = request.body(String.class);
//                    Optional<String> name = request.param("name");
//                    log.info("获取请求的body {},name {}", body, name.get());
//                    return ServerResponse.ok().body(name.get());
                    User user = new User();
                    user.setUsername("zhangsan");
                    user.setType(2);
                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(user);

                });

        return routerFunction;
    }


}
