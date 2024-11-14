package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.mapper.DistributedLockMapper;
import com.rookie.bigdata.pojo.DistributedLock;
import com.rookie.bigdata.service.DistributedLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class DistributedLockServiceImpl
 * @Description
 * @Author rookie
 * @Date 2024/11/14 17:44
 * @Version 1.0
 */
@Service
public class DistributedLockServiceImpl implements DistributedLockService {

    @Autowired
    private DistributedLockMapper distributedLockMapper;

    @Override
    public boolean tryLock(String lockName) {
        DistributedLock distributedLock = new DistributedLock();
        distributedLock.setLockName(lockName);
        DistributedLock distributedLock1 = distributedLockMapper.getDistributedLock(distributedLock);
        if (distributedLock1 != null) {
            return true;
        }


        return false;
    }

    @Override
    public int insert(DistributedLock distributedLock) {
        return distributedLockMapper.insert(distributedLock);
    }
}
