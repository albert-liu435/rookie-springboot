package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.DUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;


/**
 * @Class DUserMapperTest
 * @Description
 * @Author rookie
 * @Date 2024/11/13 17:01
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("init")
@Slf4j
class DUserMapperTest {

    @Autowired
    private DUserMapper dUserMapper;

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void findAllUser() {

        List<DUser> allUser = dUserMapper.findAllUser();
        for (DUser dUser : allUser) {
            log.info("查询出的数据为:{}",dUser);
        }
    }
}
