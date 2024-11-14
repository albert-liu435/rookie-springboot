package com.rookie.bigdata.service;

import com.rookie.bigdata.pojo.DistributedLock;

/**
 * @Class DistributedLockService
 * @Description
 * @Author rookie
 * @Date 2024/11/14 17:43
 * @Version 1.0
 */
public interface DistributedLockService {


    boolean tryLock(String lockName);

    int insert(DistributedLock distributedLock);
}
