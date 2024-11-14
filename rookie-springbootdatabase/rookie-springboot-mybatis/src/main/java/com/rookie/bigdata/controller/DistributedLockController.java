package com.rookie.bigdata.controller;

import com.rookie.bigdata.pojo.DistributedLock;
import com.rookie.bigdata.service.DistributedLockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Class DistributedLockController
 * @Description
 * @Author rookie
 * @Date 2024/11/14 17:43
 * @Version 1.0
 */
@RestController
@Slf4j
public class DistributedLockController {

    @Autowired
    private DistributedLockService distributedLockService;

    @RequestMapping("mysqlLock")
    @Transactional(rollbackFor = Exception.class)
    public String testLock() throws Exception {
        log.debug("进入testLock()方法;");
        if (distributedLockService.tryLock("order")) {
            log.debug("获取到分布式锁；");
            Thread.sleep(30 * 1000);
        } else {
            log.debug("获取分布式锁失败；");
            throw new Exception("获取分布式锁失败；");
        }

        DistributedLock distributedLock = new DistributedLock();
        distributedLock.setLockName(UUID.randomUUID().toString());

        distributedLockService.insert(distributedLock);
        if (true)
            throw new Exception("获取分布式锁失败；");
        log.debug("执行完成；");
        return "返回结果";
    }
}
