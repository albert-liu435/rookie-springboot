## Springboot Filter

#### 使用原生注解

使用@WebFilter(filterName = "myFilter", urlPatterns = "/*")注解和@ServletComponentScan(basePackages = "com.rookie.bigdata.filter.web")配合使用,将ServletComponentScan注解加到启动类上面即可，并设置扫描包
@ServletComponentScan 注解,这个注解使用 @Import 导入了 ServletComponentScanRegistrar：

ServletComponentScanRegistrar -->ServletComponentRegisteringPostProcessor -->WebFilterHandler

通过实践发现如果想要控制filer的执行顺序可以 通过控制filter的文件名的首字母来 来控制

#### 直接在 Filter 上使用 @Component 注解

```java
@Component
@Order(-1)	// 可以指定优先级，不填的话默认为最小的优先级
@Slf4j
public class ComponentUser1Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init ComponentUser1Filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("ComponentUser1Filter doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
```

或者

```java
@Bean
@Order(-3) //这个指定的顺序不起作用
public Filter ComponentUser4Filter() {
    return (request, response, chain) -> {
        log.info("ComponentUser4Filter doFilter");
        chain.doFilter(request, response);
    };
}
```

#### 使用  SpringBoot 提供的 FilterRegistrationBean

```java
    @Bean
    public FilterRegistrationBean<Logger3Filter> logger3Filter() {
        FilterRegistrationBean<Logger3Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new Logger3Filter());    // 这里可以使用 new，也可以在 Filter 上加 @Component 注入进来
        bean.addUrlPatterns("/*"); //配置过滤规则
        bean.setName("logger3Filter");
        bean.setOrder(100);    // 值越小，优先级越高
        return bean;
    }
```



参考文档：[WebFilter怎么控制多个filter的执行顺序](https://www.cnblogs.com/nextgg/p/7665814.html)

[学习笔记-Springboot结合过滤器的各种顺序问题总结](https://juejin.cn/post/7107078427148025892)

[SpringMVC - 对于如何配置 Filter 的深度剖析](https://blog.csdn.net/qiaohao0206/article/details/125655989)

[Spring Boot Web Servlet : DelegatingFilterProxyRegistrationBean](https://blog.csdn.net/andy_zhang2007/article/details/90399870)

[Spring Security 源码分析九：Java config - 加载 DelegatingFilterProxy](http://shangyang.me/2019/03/28/spring-security-sca-9-javaconfig-02-delegatingfilterproxy/)