package com.rookie.bigdata.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

/**
 * @Class SecurityConfiguration
 * @Description
 * @Author rookie
 * @Date 2024/8/13 18:24
 * @Version 1.0
 */
@Configuration(proxyBeanMethods = false)
public class SecurityConfiguration {
    /***
     * 安全配置
     * @param http http
     * @return SecurityFilterChain
     * @throws Exception exception
     */
    @Bean
    SecurityFilterChain oauth2SecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests(requests ->
//                        // 任何请求都需要认证
//                        requests.anyRequest().authenticated()
//                )
//                // oauth2三方登录
//                .oauth2Login(Customizer.withDefaults())
//
//                .oauth2Client(Customizer.withDefaults())
//                .logout(Customizer.withDefaults());
//        return http.build();

        http.authorizeRequests(requests ->
                // 任何请求都需要认证
                requests
//                        .requestMatchers()
                        .requestMatchers("/actuator/**").permitAll()
                        // 对资源A的访问，需要USER角色（admin用户具有这个角色）
                        .requestMatchers("/server/a/**").hasAnyRole("ABC")
                        // 对资源A的访问，需要TEST角色（admin用户没有这个角色）
                        .requestMatchers("/server/b/**").hasAnyRole("USER1")
                        .anyRequest().authenticated()
        );
        http.oauth2Login(Customizer.withDefaults());
        http.oauth2Client(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public RestTemplate oauth2ClientRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    /**
     * 开放一些端点的访问控制
     * 不需要认证就可以访问的端口
     * @return
     */
    //@Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers("/actuator/health", "/actuator/info");
    }

    /**
     * 虚拟一个本地用户
     *
     * @return UserDetailsService
     */
    @Bean
    UserDetailsService userDetailsService() {
        return username -> User.withUsername("local_admin")
                .password("123456")
                .roles("TEST","ABC")
                //.authorities("ROLE_ADMIN", "ROLE_USER")
                .build();
    }

}
