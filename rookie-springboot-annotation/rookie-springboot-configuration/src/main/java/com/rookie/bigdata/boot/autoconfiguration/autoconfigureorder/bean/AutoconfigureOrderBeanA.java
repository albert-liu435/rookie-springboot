package com.rookie.bigdata.boot.autoconfiguration.autoconfigureorder.bean;

import com.rookie.bigdata.framework.stereotype.component.bean.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;

/**
 * @Class AutoconfigureOrderBeanA
 * @Description SpringBoot中指定实例化顺序（方式一）
 * <p>
 *     在META-INF/spring.factories文件中添加自动化配置
 * 实例化顺序： AutoconfigureOrderBeanC > AutoconfigureOrderBeanB > AutoconfigureOrderBeanA
 * @Author rookie
 * @Date 2024/6/27 15:24
 * @Version 1.0
 */
//@Configuration
@AutoConfigureOrder(3)
public class AutoconfigureOrderBeanA {

    public static final Logger logger = LoggerFactory.getLogger(AutoconfigureOrderBeanA.class);


    public AutoconfigureOrderBeanA() {
        logger.info("AutoconfigureOrderBeanA AutoconfigureOrderBean construct");
    }
}
