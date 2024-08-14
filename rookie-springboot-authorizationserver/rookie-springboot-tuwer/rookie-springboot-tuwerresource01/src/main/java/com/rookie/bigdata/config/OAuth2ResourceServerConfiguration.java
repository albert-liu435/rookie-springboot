package com.rookie.bigdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @Class OAuth2ResourceServerConfiguration
 * @Description 资源服务器配置 当解码器JwtDecoder存在时生效
 * @Author rookie
 * @Date 2024/8/13 18:01
 * @Version 1.0
 */
@EnableWebSecurity(debug = true)
@Configuration
public class OAuth2ResourceServerConfiguration {

    /**
     * 资源管理器配置
     *
     * @param http the http
     * @return the security filter chain
     * @throws Exception the exception
     */
    @Bean
    SecurityFilterChain jwtSecurityFilterChain(HttpSecurity http) throws Exception {
        // 拒绝访问处理器 401
        SimpleAccessDeniedHandler accessDeniedHandler = new SimpleAccessDeniedHandler();
        // 认证失败处理器 403
        SimpleAuthenticationEntryPoint authenticationEntryPoint = new SimpleAuthenticationEntryPoint();

        http
                .sessionManagement(session -> {
//                    资源服务不涉及用户登录，仅靠token访问，不需要seesion；security的session生成策略改为security不主动创建session即STALELESS
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .authorizeRequests(request -> {
                    //资源权限说明：
                    //
                    //访问资源 res1，需要有 read 或 all
                    //访问资源 res2，需要有 write1 或 all

                    //对 /res1 的请求，需要 SCOPE_read 权限

                    request.requestMatchers("/res1").hasAnyAuthority("SCOPE_read", "SCOPE_all")
                            .requestMatchers("/res2").hasAnyAuthority("SCOPE_write1", "SCOPE_all")
                            // 其余请求都需要认证
                            .anyRequest().authenticated();
                });
        http
                // 异常处理
                .exceptionHandling(exceptionConfigurer -> exceptionConfigurer

                        // 拒绝访问
                        .accessDeniedHandler(accessDeniedHandler)
                        // 认证失败
                        .authenticationEntryPoint(authenticationEntryPoint)
                );
        http
                // 资源服务
                .oauth2ResourceServer(resourceServer -> resourceServer
                        .accessDeniedHandler(accessDeniedHandler)
                        .authenticationEntryPoint(authenticationEntryPoint)
                        .jwt(Customizer.withDefaults())
                );
        return
                http.build();
    }

    /**
     * JWT个性化解析
     *
     * @return
     */
    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
//        如果不按照规范  解析权限集合Authorities 就需要自定义key
//        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("scopes");
//        OAuth2 默认前缀是 SCOPE_     Spring Security 是 ROLE_
//        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("");
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        // 用户名 可以放sub
        jwtAuthenticationConverter.setPrincipalClaimName(JwtClaimNames.SUB);
        return jwtAuthenticationConverter;
    }
}
