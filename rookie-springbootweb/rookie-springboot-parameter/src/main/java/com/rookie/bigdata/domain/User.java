package com.rookie.bigdata.domain;

import com.rookie.bigdata.annotation.EnumValue;
import com.rookie.bigdata.annotation.QsmSpecifiedSelector;
import com.rookie.bigdata.annotation.SspClaimEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @Classname User
 * @Description
 * @Author rookie
 * @Date 2021/8/18 9:41
 * @Version 1.0
 */
@Data
public class User implements Serializable {

    /**
     * 账号状态
     */
    @EnumValue(enumClass = UserStatusEnum.class, enumMethod = "isValidName",message = "必须为特定的值")
    private String status;


    @QsmSpecifiedSelector(enumValue = SspClaimEnum.Nation.class, message = "国家必须为指定值a,b")
    private String nation;

    @QsmSpecifiedSelector(strValues = {"qsm", "hn"}, message = "姓名必须为指定值qsm,hn")
    private String name;

    @QsmSpecifiedSelector(intValues = {0, 1}, message = "学生标志必须为指定值0,1")
    private Integer studentFlag;


}



