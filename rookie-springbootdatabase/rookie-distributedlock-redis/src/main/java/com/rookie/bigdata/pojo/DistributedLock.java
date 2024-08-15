package com.rookie.bigdata.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Class DistributedLock
 * @Description
 * @Author rookie
 * @Date 2024/8/15 10:54
 * @Version 1.0
 */
@Data
public class DistributedLock implements Serializable {

    private String lockName;
}
