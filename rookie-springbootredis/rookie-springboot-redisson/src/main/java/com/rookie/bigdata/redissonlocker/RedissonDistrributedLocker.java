package com.rookie.bigdata.redissonlocker;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedissonDistrributedLocker
 * @Description RedissonDistrributedLocker
 * @Author rookie
 * @Date 2021/6/22 9:56
 * @Version 1.0
 */
public interface RedissonDistrributedLocker {
    RLock lock(String lockKey);

    RLock lock(String lockKey, int timeout);

    RLock lock(String lockKey, TimeUnit unit, int timeout);

    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);

    void unlock(String lockKey);

    void unlock(RLock lock);
}
