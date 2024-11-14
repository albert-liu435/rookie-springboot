package com.rookie.bigdata.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Class DistributedLock
 * @Description
 * @Author rookie
 * @Date 2024/11/14 17:42
 * @Version 1.0
 */
@Data
public class DistributedLock implements Serializable {

    private String lockName;
}
