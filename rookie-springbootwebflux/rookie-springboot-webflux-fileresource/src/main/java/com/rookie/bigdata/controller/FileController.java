package com.rookie.bigdata.controller;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 21:32
 * @Version 1.0
 */
@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<Map> upload(@RequestPart("file") FilePart filePart, FormData formData) throws IOException {

        logger.info("收到的描述信息为：{}", formData);
        logger.info("收到的文件名称为：{}",filePart.filename());

        Path path = Files.createTempFile("abc", filePart.filename());
//        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
//        DataBufferUtils.write(filePart.content(), channel, 0).doOnComplete(() -> {
//            logger.info("完成：{}", filePart.filename());
//
//        }).subscribe();

//        //
//        filePart.transferTo(path.toFile());


//        Map<String, Object> map = new HashMap<>();
//        map.put("name", filePart.filename());
//
//
//        return Mono.just(map);

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

    @Data
    public static class FormData {

        private String desc;

    }






}
