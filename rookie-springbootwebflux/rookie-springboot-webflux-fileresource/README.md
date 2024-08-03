# rookie-webflux-file

### 文件上传

代码如下

```java
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<Map> upload(@RequestPart("file") FilePart filePart, FormData formData) throws IOException {

        logger.info("收到的描述信息为：{}", formData);
        logger.info("收到的文件名称为：{}",filePart.filename());

        Path path = Files.createTempFile("abc", filePart.filename());

        final File directory = new File("/temp");
        if(!directory.exists()){
            directory.mkdirs();
        }

        final File file = new File(directory, filePart.filename());

        return filePart
                .transferTo(file)
                .then(Mono.fromCallable(() -> {
                    final Map<String, Object> map = new HashMap<>();
                    map.put("name", file.getName());
                    map.put("lastModified", file.lastModified());
                    map.put("size", file.length());
                    return map;
                }));


    }
```

设置上传文件大小

```java
@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {

        SynchronossPartHttpMessageReader partReader = new SynchronossPartHttpMessageReader();
        partReader.setMaxParts(1024);
        //字节bytes
        partReader.setMaxDiskUsagePerPart(1024 *1000000);
        partReader.setEnableLoggingRequestDetails(true);

        // 单文件上传大小限制
        MultipartHttpMessageReader multipartReader = new MultipartHttpMessageReader(partReader);
        multipartReader.setEnableLoggingRequestDetails(true);
        configurer.defaultCodecs().multipartReader(multipartReader);



    }
}
```

进行测试

![1650874819](.\1650874819.png)

### 文件下载

文件下载源码

```java
@RestController
public class FileDownLoadController {
    private static final Logger logger = LoggerFactory.getLogger(FileDownLoadController.class);


    @RequestMapping("/download")
    public Mono<Void> downloadImage(ServerHttpResponse response) throws IOException {

        ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=webflux.png");
        response.getHeaders().setContentType(MediaType.IMAGE_PNG);

        Resource resource = new ClassPathResource("/img/webflux.png");
        File file = resource.getFile();
        return zeroCopyResponse.writeWith(file, 0, file.length());

    }


    @GetMapping({"/download2"})
    public Mono<ResponseEntity<Resource>> downloadImage2() {


        return Mono.just(
                ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=webflux.png")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                        .body(new ClassPathResource("/img/webflux.png"))
        );
    }


    @GetMapping("/download3")
    public Mono<ResponseEntity<Resource>> downloadImage3() {
        String fileName = "webflux.png";


        return Mono.create((MonoSink<InputStream> callback) -> {
            try {
                callback.success(getClass().getResourceAsStream("/img/" + fileName));
            } catch (Exception ex) {
                //  log.warn("read stream error => ", ex);
                callback.error(ex);
            }
        }).switchIfEmpty(Mono.error(new NotFoundException(fileName + " not found")))
                .map(stream -> {
                    return ResponseEntity.ok()
                            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                            .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                            .body(new InputStreamResource(stream));
                });

    }

}
```

分别访问如下即可下载图片

http://localhost:9000/download

http://localhost:9000/download2

http://localhost:9000/download3

