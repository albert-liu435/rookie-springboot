package com.rookie.bigdata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class PathVariableController
 * @Description https://blog.csdn.net/weixin_44188105/article/details/131696941
 * @Author rookie
 * @Date 2024/8/2 13:59
 * @Version 1.0
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class PathVariableController {


    @RequestMapping("/resource/{appid}")
    public String endpointApp(@PathVariable(value = "appid") String appid) {
        log.info("appid:{}", appid);
        return "endpoint";
    }
//    }

}


//## 1-String value：可指定占位符 { } 中的参数名，若只指定value这一个属性可省略属性名不写，若占位符中的参数名和处理方法中的参数名相同可省略此属性。
//        举例-1-开始
//@RequestMapping(value="/user/{userName}")
//public String username(@PathVariable(value ="userName",required = true,defaultValue = "法外狂徒张三",name = "userName") String userName) {
//        return username;
//        }
//        因为{userName}内userName与String userName的相同===》(若占位符中的参数名和处理方法中的参数名相同可省略此属性)
//        修改为
//@RequestMapping(value="/user/{userName}")
//public String username(@PathVariable(required = true,defaultValue = "法外狂徒张三") String userName) {
//        return username;
//        }
//        举例-1-结束
//
//        ## 2-boolean required：是否必需，默认为 true，即 请求中必须包含该参数，如果没有包含，将会抛出异常（可选配置）
//        举例-2-开始
//@RequestMapping(value="/user/{userName}")
//public String username(@PathVariable(value ="userName",required = true) String username) {
//        return username;
//        }
//        举例-2-结束
//
//        ## 3-String name：等价与value，和value无本质上的差异，两个属性指定其一即可
//
//@RequestMapping(value="/user/{userName}")
//public String username(@PathVariable(value ="userName",required = true,defaultValue = "法外狂徒张三") String username) {
//        return username;
//        }
//

