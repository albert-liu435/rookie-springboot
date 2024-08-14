package com.rookie.bigdata.util;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Class Result
 * @Description 结果对象
 * @Author rookie
 * @Date 2024/8/13 15:15
 * @Version 1.0
 */
@Data
@Setter(AccessLevel.NONE)
public class Result {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 数据
     */
    private Object data;
    /**
     * 时间
     */
    private LocalDateTime time;

    public Result(Integer code,Object data){
        this.code = code;
        this.data = data;
        this.time = LocalDateTime.now();
    }
}
