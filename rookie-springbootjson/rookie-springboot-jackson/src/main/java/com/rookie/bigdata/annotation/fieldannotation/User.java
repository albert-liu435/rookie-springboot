package com.rookie.bigdata.annotation.fieldannotation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName User
 * @Description User
 * @Author rookie
 * JsonProperty:
 * JsonProperty可以作用在成员变量和方法上，作用是在序列化和反序列化操作中指定json字段的名称,其中value代表json的属性名，index:序列化结果的顺序
 * JsonIgnore:
 * JsonIgnore好理解，作用在成员变量或者方法上，指定被注解的变量或者方法不参与序列化和反序列化操作
 * JsonSerialize:
 * JsonSerialize用于序列化场景，被此注解修饰的字段或者get方法会被用于序列化，并且using属性指定了执行序列化操作的类；
 * 执行序列化操作的类，需要继承自JsonSerializer,如下将date时间戳转换为String日期类型
 * JsonDeserialize：
 * 作用与JsonSerialize刚好相反
 * @Date 2021/6/17 10:51
 * @Version 1.0
 */
@Data
public class User {

    @JsonProperty(value = "ID", index = 1)
    private long id;

    @JsonProperty(value = "usr", index = 0)
    private String username;
    @JsonIgnore
    private String address;

    private String degree;

    private int type;

    //默认序列化为时间戳
    @JsonSerialize(using = Long2StringSerialize.class)
    private Date date;
    @JsonDeserialize(using = Long2DateDeserialize.class)
    private Date birthDate;

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // 美化输出
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // jackson支持Optional特性
        mapper.registerModule(new Jdk8Module());

        User user = new User();
        user.setId(10);
        user.setUsername("zhangsan");
        user.setAddress("河北邯郸");
        user.setDegree("小学");
        user.setType(2);
        user.setDate(new Date());
        user.setBirthDate(new Date());

        String jsonStr = mapper.writeValueAsString(user);
        System.out.println(jsonStr);

        System.out.println(mapper.readValue(jsonStr, User.class));
    }
}
