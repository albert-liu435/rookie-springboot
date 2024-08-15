package com.rookie.bigdata.second;

/**
 * @Class HttpStatusInfoInterface
 * @Description 为了代码解耦，创建一个接口类出来，定义自定义接口所需要的方法
 * Http状态信息接口
 * @Author rookie
 * @Date 2024/8/15 10:28
 * @Version 1.0
 */
public interface HttpStatusInfoInterface {

    int getCode();

    String getMessage();

}
