package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.TabUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;


/**
 * @Class TabUserMapperTest
 * @Description
 * @Author rookie
 * @Date 2024/11/13 13:35
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("init")
@Slf4j
class TabUserMapperTest {


    @Autowired
    private TabUserMapper tabUserMapper;





    @Test
    void selectByPrimaryKey() {

        TabUser tabUser = tabUserMapper.selectByPrimaryKey(36663930135646208L);
        log.info("查询出的tabUser: {}",tabUser);
    }

    @Test
    void findAllUser(){
        List<TabUser> allUser = tabUserMapper.findAllUser();
        for (TabUser tabUser : allUser) {
            log.info("查询出的tabUser: {}",tabUser);
        }
    }
}
