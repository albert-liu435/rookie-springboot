package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.TabUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Date;
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
    void insert(){
        TabUser tabUser=new TabUser();
        tabUser.setAge(23);
        tabUser.setId(100L);
        tabUser.setName("aaa");
        tabUser.setCreateTime(new Date());
        tabUser.setUpdateTime(new Date());
        tabUser.setStatus(0);
        int insert = tabUserMapper.insert(tabUser);
        log.info("insert的数据量：{}",insert);

    }

    @Test
    void insertSelective(){
        TabUser tabUser=new TabUser();
        tabUser.setAge(23);
        tabUser.setId(101L);
        tabUser.setName("aaa");
        tabUser.setCreateTime(new Date());
        tabUser.setUpdateTime(new Date());
        tabUser.setStatus(0);
        int insert = tabUserMapper.insertSelective(tabUser);
        log.info("insert的数据量：{}",insert);
    }


    @Test
    void insertForeach(){
        List<TabUser> tabUsers=new ArrayList<>();
        TabUser tabUser=new TabUser();
        tabUser.setAge(23);
        tabUser.setId(102L);
        tabUser.setName("aaa");
        tabUser.setCreateTime(new Date());
        tabUser.setUpdateTime(new Date());
        tabUser.setStatus(0);

        tabUsers.add(tabUser);
        int insert = tabUserMapper.insertForeach(tabUsers);
        log.info("insert的数据量：{}",insert);

    }



    @Test
    void deleteTabUser(){
        TabUser tabUser=new TabUser();
        tabUser.setAge(23);
        tabUser.setId(101L);
        tabUser.setName("aaa");
        tabUser.setCreateTime(new Date());
        tabUser.setUpdateTime(new Date());
        tabUser.setStatus(0);
        int insert = tabUserMapper.deleteTabUser(tabUser);
        log.info("insert的数据量：{}",insert);
    }


    @Test
    void updateByPrimaryKeySelective(){
        TabUser tabUser=new TabUser();
        tabUser.setAge(23);
        tabUser.setId(102L);
        tabUser.setName("aaa");
        tabUser.setCreateTime(new Date());
        tabUser.setUpdateTime(new Date());
        tabUser.setStatus(1);
        int insert = tabUserMapper.updateByPrimaryKeySelective(tabUser);
        log.info("insert的数据量：{}",insert);

    }




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
