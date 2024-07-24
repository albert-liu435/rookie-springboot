package com.rookie.bigdata;

import com.rookie.bigdata.boot.autoconfiguration.autoconfigureorder.bean.AutoconfigureOrderBeanA;
import com.rookie.bigdata.boot.autoconfiguration.bean.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;

/**
 * @ClassName SpringCustomerRetryApplication
 * @Description SpringCustomerRetryApplication
 * @Author rookie  参考 https://blog.csdn.net/cckevincyh/article/details/112347200
 * @Date 2021/6/17 11:32
 * @Version 1.0
 */
@SpringBootApplication

public class SpringConfigurationApplication {

//    @Autowired
//    private AutoconfigureOrderBeanA autoconfigureOrderBeanA;

    public static void main(String[] args) {


        SpringApplication.run(SpringConfigurationApplication.class, args);


    }
}
