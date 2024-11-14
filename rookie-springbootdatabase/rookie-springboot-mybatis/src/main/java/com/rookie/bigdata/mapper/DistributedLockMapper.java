package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.DistributedLock;

/**
 * @Class DistributedLockMapper
 * @Description
 * @Author rookie
 * @Date 2024/11/14 17:42
 * @Version 1.0
 */
public interface DistributedLockMapper {

    DistributedLock getDistributedLock(DistributedLock lock);

    int insert(DistributedLock lock);

}
