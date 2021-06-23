package com.rookie.bigdata.redissonlocker.impl;

import com.rookie.bigdata.redissonlocker.RedissonDistrributedLocker;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedissonDistrributedLockerImpl
 * @Description RedissonDistrributedLockerImpl
 * @Author rookie
 * @Date 2021/6/22 9:56
 * @Version 1.0
 */
public class RedissonDistrributedLockerImpl implements RedissonDistrributedLocker {
    private RedissonClient redissonClient;

    @Override
    public RLock lock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock();
        return lock;
    }

    @Override
    public RLock lock(String lockKey, int leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(leaseTime, TimeUnit.SECONDS);
        return lock;
    }

    @Override
    public RLock lock(String lockKey, TimeUnit unit, int timeout) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout, unit);
        return lock;
    }

    @Override
    public boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            return false;
        }
    }

    @Override
    public void unlock(String lockKey) {
//        RLock lock = redissonClient.getLock(lockKey);
//        lock.unlock();

        try {
            RLock lock = redissonClient.getLock(lockKey);
            if (lock != null && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        } catch (Throwable e) {
            String msg = String.format("UNLOCK FAILED: key=%s", lockKey);
            throw new IllegalStateException(msg, e);
        }


    }

    @Override
    public void unlock(RLock lock) {
        lock.unlock();
    }

    public void setRedissonClient(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }
}
