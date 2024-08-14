package com.rookie.bigdata.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


/**
 * @Class AuthorizationConfig
 * @Description 认证配置
 * {@link EnableMethodSecurity} 开启全局方法认证，启用JSR250注解支持，启用注解 {@link Secured} 支持，
 * 在Spring Security 6.0版本中将@Configuration注解从@EnableWebSecurity, @EnableMethodSecurity, @EnableGlobalMethodSecurity
 * 和 @EnableGlobalAuthentication 中移除，使用这些注解需手动添加 @Configuration 注解
 * {@link EnableWebSecurity} 注解有两个作用:
 * 1. 加载了WebSecurityConfiguration配置类, 配置安全认证策略。
 * 2. 加载了AuthenticationConfiguration, 配置了认证信息。
 * @Author rookie
 * @Date 2024/3/26 9:43
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity(debug = true)
//@EnableWebSecurity()
@EnableMethodSecurity(jsr250Enabled = true, securedEnabled = true)
public class OAuth2AuthorizationServerSecurityConfiguration {

    private static final String CUSTOM_CONSENT_PAGE_URI = "/oauth2/consent";

    /**
     * 配置端点的过滤器链
     *
     * @param http spring security核心配置类
     * @return 过滤器链
     * @throws Exception 抛出
     */
    @Bean
    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
        // 配置默认的设置，忽略认证端点的csrf校验
        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);

        http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
                // 开启OpenID Connect 1.0协议相关端点
                .oidc(Customizer.withDefaults())
                // 设置自定义用户确认授权页
                .authorizationEndpoint(authorizationEndpoint -> authorizationEndpoint.consentPage(CUSTOM_CONSENT_PAGE_URI));
        http
                // 当未登录时访问认证端点时重定向至login页面
                .exceptionHandling((exceptions) -> exceptions
                        .defaultAuthenticationEntryPointFor(
                                new LoginUrlAuthenticationEntryPoint("/login"),
                                new MediaTypeRequestMatcher(MediaType.TEXT_HTML)
                        )
                )
//                .logout(Customizer.withDefaults())
                .logout(logOut -> {
                    //定义登出
                    AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher("/logout", "GET");

                    logOut.logoutRequestMatcher(antPathRequestMatcher);
                })
//                .logout(logOut->logOut.logoutSuccessUrl("http://rookie-tuwer.client.com:8900"))
                // 处理使用access token访问用户信息端点和客户端注册端点
                .oauth2ResourceServer((resourceServer) -> resourceServer
                        .jwt(Customizer.withDefaults()));

        return http.build();
    }

    /**
     * 配置认证相关的过滤器链
     *
     * @param http spring security核心配置类
     * @return 过滤器链
     * @throws Exception 抛出
     */
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        // 放行静态资源
                        .requestMatchers("/assets/**", "/webjars/**", "/login").permitAll()
                        .anyRequest().authenticated()
                )
//                .logout(logOut->logOut.logoutSuccessUrl("http://rookie-tuwer.client.com:8900"))
                .logout(logOut -> {
                    AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher("/logout", "GET");

                    logOut.logoutRequestMatcher(antPathRequestMatcher);
                })
                // 指定登录页面,
                .formLogin(formLogin ->
                        formLogin.loginPage("/login")
                );

        // 指定登录页面,因为默认为/login，所以这里应该也可以写成
//                .formLogin(Customizer.withDefaults());

        // 添加BearerTokenAuthenticationFilter，将认证服务当做一个资源服务，解析请求头中的token
        http.oauth2ResourceServer((resourceServer) -> resourceServer
                .jwt(Customizer.withDefaults()));

        return http.build();
    }

    /**
     * 配置密码解析器，使用BCrypt的方式对密码进行加密和验证
     *
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RegisteredClientRepository registeredClientRepository(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
        // ---------- 1、检查当前客户端是否已注册
        // 操作数据库对象
        JdbcRegisteredClientRepository registeredClientRepository = new JdbcRegisteredClientRepository(jdbcTemplate);

        /*
         客户端在数据库中记录的区别
         ------------------------------------------
         id：仅表示客户端在数据库中的这个记录
         client_id：唯一标示客户端；请求token时，以此作为客户端的账号
         client_name：客户端的名称，可以省略
         client_secret：密码
         */
        String clientId_1 = "my_client";
        String clientId_2 = "micro_service";
        // 查询客户端是否存在
        RegisteredClient registeredClient_1 = registeredClientRepository.findByClientId(clientId_1);
        RegisteredClient registeredClient_2 = registeredClientRepository.findByClientId(clientId_2);

        // ---------- 2、添加客户端
        // 数据库中没有
        if (registeredClient_1 == null) {
            registeredClient_1 = this.createRegisteredClientAuthorizationCode(clientId_1, passwordEncoder);
            registeredClientRepository.save(registeredClient_1);
        }
        // 数据库中没有
        if (registeredClient_2 == null) {
            registeredClient_2 = this.createRegisteredClient(clientId_2, passwordEncoder);
            registeredClientRepository.save(registeredClient_2);
        }

        // ---------- 3、返回客户端仓库
        return registeredClientRepository;
    }

    /**
     * 定义客户端（令牌申请方式：授权码模式）
     *
     * @param clientId 客户端ID
     * @return
     */
    private RegisteredClient createRegisteredClientAuthorizationCode(final String clientId, PasswordEncoder passwordEncoder) {
        // JWT（Json Web Token）的配置项：TTL、是否复用refrechToken等等
        TokenSettings tokenSettings = TokenSettings.builder()
                // 令牌存活时间：2小时
                .accessTokenTimeToLive(Duration.ofHours(2))
                // 令牌可以刷新，重新获取
                .reuseRefreshTokens(true)
                // 刷新时间：30天（30天内当令牌过期时，可以用刷新令牌重新申请新令牌，不需要再认证）
                .refreshTokenTimeToLive(Duration.ofDays(30))
                .build();
        // 客户端相关配置
        ClientSettings clientSettings = ClientSettings.builder()
                // 是否需要用户授权确认
                .requireAuthorizationConsent(false)
                .build();

        return RegisteredClient
                // 客户端ID和密码
                .withId(UUID.randomUUID().toString())
                //.withId(id)
                .clientId(clientId)
                //.clientSecret("{noop}123456")
                .clientSecret(passwordEncoder.encode("123456"))
                // 客户端名称：可省略
                .clientName("my_client_name")
                // 授权方法
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                // 授权模式
                // ---- 【授权码模式】
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                // ---------- 刷新令牌（授权码模式）
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                /* 回调地址：
                 * 授权服务器向当前客户端响应时调用下面地址；
                 * 不在此列的地址将被拒统；
                 * 只能使用IP或域名，不能使用localhost
                 */
                .redirectUri("http://rookie-tuwer.client.com:8900/login/oauth2/code/myClient")
                .redirectUri("http://rookie-tuwer.client.com:8900")
                .redirectUri("https://www.baidu.com")
                // 授权范围（当前客户端的授权范围）
                .scope("read")
                .scope("write")
                // 客户端设置，设置用户需要确认授权
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
                //有效期设置为12年，如果不设置的话，默认为当前时间，则马上回过期不能使用
                .clientSecretExpiresAt(Instant.now().plus(12 * 365, ChronoUnit.DAYS))
//                //设置2天有效期
                .tokenSettings(TokenSettings.builder().authorizationCodeTimeToLive(Duration.ofDays(2)).accessTokenTimeToLive(Duration.ofDays(2)).build())
//                // JWT（Json Web Token）配置项
//                .tokenSettings(tokenSettings)
//                // 客户端配置项
//                .clientSettings(clientSettings)
                .build();
    }

    /**
     * 定义客户端（令牌申请方式：客户端模式）
     *
     * @param clientId 客户端ID
     * @return
     */
    private RegisteredClient createRegisteredClient(final String clientId, PasswordEncoder passwordEncoder) {
        // JWT（Json Web Token）的配置项：TTL、是否复用refrechToken等等
        TokenSettings tokenSettings = TokenSettings.builder()
                // 令牌存活时间：1年
                .accessTokenTimeToLive(Duration.ofDays(365))
                // 令牌不可以刷新
                //.reuseRefreshTokens(false)
                .build();
        // 客户端相关配置
        ClientSettings clientSettings = ClientSettings.builder()
                // 是否需要用户授权确认
                .requireAuthorizationConsent(false)
                .build();

        return RegisteredClient
                // 客户端ID和密码
                .withId(UUID.randomUUID().toString())
                //.withId(id)
                .clientId("micro_service")
                //.clientSecret("{noop}123456")
                .clientSecret(passwordEncoder.encode("123456"))
                // 客户端名称：可省略
                .clientName("micro_service")
                // 授权方法
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                // 授权模式
                // ---- 【客户端模式】
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                /* 回调地址：
                 * 授权服务器向当前客户端响应时调用下面地址；
                 * 不在此列的地址将被拒统；
                 * 只能使用IP或域名，不能使用localhost
                 */
                .redirectUri("http://rookie-tuwer.resource1.com:8001")
                .redirectUri("http://rookie-tuwer.resource2.com:8002")
                .redirectUri("https://www.baidu.com")
                // 授权范围（当前客户端的角色）
                .scope("all")
//                // JWT（Json Web Token）配置项
//                .tokenSettings(tokenSettings)
//                // 客户端配置项
//                .clientSettings(clientSettings)

                // 客户端设置，设置用户需要确认授权
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
                //有效期设置为12年，如果不设置的话，默认为当前时间，则马上回过期不能使用
                .clientSecretExpiresAt(Instant.now().plus(12 * 365, ChronoUnit.DAYS))
//                //设置2天有效期
                .tokenSettings(TokenSettings.builder().authorizationCodeTimeToLive(Duration.ofDays(2)).accessTokenTimeToLive(Duration.ofDays(2)).build())
                .build();
    }

    /**
     * 配置基于db的oauth2的授权管理服务
     *
     * @param jdbcTemplate               db数据源信息
     * @param registeredClientRepository 上边注入的客户端repository
     * @return JdbcOAuth2AuthorizationService
     */
    @Bean
    public OAuth2AuthorizationService authorizationService(JdbcTemplate jdbcTemplate, RegisteredClientRepository registeredClientRepository) {
        // 基于db的oauth2认证服务，还有一个基于内存的服务实现InMemoryOAuth2AuthorizationService
        return new JdbcOAuth2AuthorizationService(jdbcTemplate, registeredClientRepository);
    }

    /**
     * 配置基于db的授权确认管理服务
     *
     * @param jdbcTemplate               db数据源信息
     * @param registeredClientRepository 客户端repository
     * @return JdbcOAuth2AuthorizationConsentService
     */
    @Bean
    public OAuth2AuthorizationConsentService authorizationConsentService(JdbcTemplate jdbcTemplate, RegisteredClientRepository registeredClientRepository) {
        // 基于db的授权确认管理服务，还有一个基于内存的服务实现InMemoryOAuth2AuthorizationConsentService
        return new JdbcOAuth2AuthorizationConsentService(jdbcTemplate, registeredClientRepository);
    }

    /**
     * 加载jwk资源
     * 用于生成令牌
     *
     * @return
     */
    @SneakyThrows
    @Bean
    public JWKSource<SecurityContext> jwkSource() {
        // 证书的路径
        String path = "myjks.jks";
        // 证书别名
        String alias = "myjks";
        // keystore 密码
        String pass = "123456";

        ClassPathResource resource = new ClassPathResource(path);
        KeyStore jks = KeyStore.getInstance("jks");
        char[] pin = pass.toCharArray();
        jks.load(resource.getInputStream(), pin);
        RSAKey rsaKey = RSAKey.load(jks, alias, pin);

        JWKSet jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }


    /**
     * jwt解码器
     * 客户端认证授权后，需要访问user信息，解码器可以从令牌中解析出user信息
     *
     * @return
     */
    @SneakyThrows
    @Bean
    JwtDecoder jwtDecoder() {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("x.509");
        // 读取cer公钥证书来配置解码器
        ClassPathResource resource = new ClassPathResource("myjks.cer");
        Certificate certificate = certificateFactory.generateCertificate(resource.getInputStream());
        RSAPublicKey publicKey = (RSAPublicKey) certificate.getPublicKey();
        return NimbusJwtDecoder.withPublicKey(publicKey).build();
    }


    /**
     * 添加认证服务器配置，设置jwt签发者、默认端点请求地址等
     *
     * @return AuthorizationServerSettings
     */
    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {

//        http://rookie-tuwer.server.com:9000
//        return AuthorizationServerSettings.builder().build();
        return AuthorizationServerSettings.builder()
                /*
                    设置token签发地址(http(s)://{ip}:{port}/context-path, http(s)://domain.com/context-path)
                    如果需要通过ip访问这里就是ip，如果是有域名映射就填域名，通过什么方式访问该服务这里就填什么
                 */
//                .issuer("http://192.168.120.33:8080")
                .issuer("http://rookie-tuwer.server.com:9000")
                .build();
    }

    /**
     * 先暂时配置一个基于内存的用户，框架在用户认证时会默认调用
     * {@link UserDetailsService#loadUserByUsername(String)} 方法根据
     * 账号查询用户信息，一般是重写该方法实现自己的逻辑
     *
     * @param passwordEncoder 密码解析器
     * @return UserDetailsService
     */
    @Bean
    public UserDetailsService users(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("admin")
                .password(passwordEncoder.encode("123456"))
                .roles("admin", "normal", "unAuthentication")
                .authorities("app", "web", "/test2", "/test3")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}

