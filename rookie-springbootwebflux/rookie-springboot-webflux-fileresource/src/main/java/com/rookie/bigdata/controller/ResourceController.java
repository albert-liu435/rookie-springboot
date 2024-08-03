package com.rookie.bigdata.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.io.InputStream;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 21:38
 * @Version 1.0
 */
@Controller
public class ResourceController {


    @GetMapping({"/code/mvc-context"})
    public Mono<ResponseEntity<Resource>> codeImage() {
        return Mono.just(
                ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=mvc-context.png")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                        .body(new ClassPathResource("imag/mvc-context.png"))
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
