package com.rookie.bigdata.controller;

import com.rookie.bigdata.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 21:33
 * @Version 1.0
 */
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

