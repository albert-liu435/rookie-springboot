package com.rookie.bigdata.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Class Log
 * @Description
 * @Author rookie
 * @Date 2024/1/17 16:39
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Log {

    private Long id;

    private String log;
    private Date time;
}
