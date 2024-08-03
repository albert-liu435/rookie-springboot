# rookie-webflux-resources

webflux获取资源文件

### 默认加载资源文件

Springboot有一个默认加载资源文件的顺序，默认的加载顺序如下

classpath:/META-INF/resources/

classpath:/resources/

classpath:/static/

 classpath:/public/

可以在org.springframework.boot.autoconfigure.web.WebProperties类中找到，在访问资源的时候，一旦资源找到就不会再迭代查找，如从classpath:/META-INF/resources/找到后，就不会再从classpath:/resources/目录中进行查找

如运行本示例并访问http://localhost:9000/webflux.png可以得到验证

### 自定义资源路径

自定义资源路径可以在配置文件中加入相关配置，如下

```yaml
spring:
  webflux:
    #如果添加该配置则在访问资源的时候需要加前缀/assets/
    static-path-pattern: /assets/**
  web:
    resources:
      #自定义资源路径
      static-locations: classpath:/imag/
```

启动程序并访问http://localhost:9000/assets/mvc-context.png

如果不配置static-path-pattern，则直接访问http://localhost:9000/mvc-context.png即可

### 编写代码访问

代码如下

```java
@Controller
public class ResourceController {


    @GetMapping({"/code/mvc-context"})
    public Mono<ResponseEntity<Resource>> codeImage() {
        return Mono.just(
                ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=mvc-context.png")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                        .body(new ClassPathResource("image/mvc-context.png"))
        );
    }

    @GetMapping("/code/mvc-context2")
    public Mono<ResponseEntity<? extends Resource>> codeImage2() {
//        String fileName = "mvc-context.png";

        return Mono.create((MonoSink<InputStream> callback) -> {
            callback.success(getClass().getResourceAsStream("/imag/mvc-context.png"));
        }).switchIfEmpty(Mono.error(new Exception("文件没有找到")))
                .map(stream -> {
                    return ResponseEntity.ok()
                            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=mvc-context.png")
                            .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                            .body(new InputStreamResource(stream));
                });

    }


}
```

运行程序，然后访问如下url即可

http://localhost:9000/code/mvc-context

http://localhost:9000/code/mvc-context2
