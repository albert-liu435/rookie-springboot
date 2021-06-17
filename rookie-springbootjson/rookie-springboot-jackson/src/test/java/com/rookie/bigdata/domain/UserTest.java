package com.rookie.bigdata.domain;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName UserTest
 * @Description UserTest
 * @Author rookie
 * @Date 2021/6/17 9:36
 * @Version 1.0
 */
public class UserTest {


    private static JsonFactory jsonFactory = new JsonFactory();

    @Test
    public void test1() throws Exception {
        User user = new User();
        user.setId(10L);
        user.setUsername("张三");
        user.setType(2);

        String userStr = serialize(user);
        System.out.println(userStr);

        User user1 = deserializeJSONStr(userStr);
        System.out.println(user1);


    }

    @Test
    public void test2() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        //序列化结果格式化
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        //空对象不要抛出异常
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);


        User user = new User();
        user.setId(10L);
        user.setUsername("张三");
        user.setType(2);

        String jsonStr = mapper.writeValueAsString(user);
        System.out.println("序列化的字符串: " + jsonStr);

        User user1 = new User();
        String jsonStr1 = mapper.writeValueAsString(user1);
        System.out.println("序列化的字符串: " + jsonStr1);

        String jsonStr2 = mapper.writeValueAsString(null);
        System.out.println("序列化的字符串: " + jsonStr2);

        //将对象转换为json字符串，并写入到文件中
        // mapper.writeValue(new File("src/main/resources/twitter.json"), user);


    }

    @Test
    public void test3() throws Exception {
        //map结构的数据转换为json数据
        Map<String, Object> map = new HashMap<>();
        map.put("name", "lisi");
        map.put("age", 23);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(map);
        System.out.println(jsonStr);
        Map<String, Object> mapFromStr = mapper.readValue(jsonStr, new TypeReference<Map<String, Object>>() {
        });

        System.out.println("从字符串反序列化的HashMap对象:" + mapFromStr);

        JsonNode jsonNode = mapper.readTree(jsonStr);
        String name = jsonNode.get("name").asText();
        int age = jsonNode.get("age").asInt();
        System.out.println("name：" + name);
        System.out.println("age:" + age);

    }

    @Test
    public void test4() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Date> map = new HashMap<>();
        map.put("date", new Date());

        String dateMapStr = mapper.writeValueAsString(map);
        System.out.println(dateMapStr);

        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
        dateMapStr = mapper.writeValueAsString(map);
        System.out.println(dateMapStr);


    }


    public static User deserializeJSONStr(String json) throws Exception {
        //sonParser负责将JSON解析成对象的变量值，核心是循环处理JSON中的所有内容
        JsonParser jsonParser = jsonFactory.createParser(json);

        if (jsonParser.nextToken() != JsonToken.START_OBJECT) {
            jsonParser.close();
        }

        User user = new User();

        try {
            // 对json字符串进行迭代
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {

                String fieldName = jsonParser.getCurrentName();

                System.out.println("解析的字符串为：" + fieldName);

                // 解析下一个
                jsonParser.nextToken();

                switch (fieldName) {
                    case "id":
                        user.setId(jsonParser.getLongValue());
                        break;
                    case "username":
                        user.setUsername(jsonParser.getText());
                        break;
                    case "type":
                        user.setType(jsonParser.getIntValue());
                        break;

                    default:
                        System.out.println("未知字段：" + fieldName);

                }
            }
        } catch (IOException e) {
            //  logger.error("反序列化出现异常 :", e);
        } finally {
            jsonParser.close(); // important to close both parser and underlying File reader
        }

        return user;
    }

    /**
     * 将对象序列化为json字符串
     *
     * @param user
     * @return
     * @throws Exception
     */
    public static String serialize(User user) throws Exception {


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JsonGenerator jsonGenerator = jsonFactory.createGenerator(byteArrayOutputStream, JsonEncoding.UTF8);

        try {
            jsonGenerator.useDefaultPrettyPrinter();

            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", user.getId());
            jsonGenerator.writeStringField("username", user.getUsername());
            jsonGenerator.writeNumberField("type", user.getType());
            jsonGenerator.writeEndObject();
        } catch (IOException e) {

        } finally {
            jsonGenerator.close();
        }

        // 一定要在
        String rlt = byteArrayOutputStream.toString();

        return rlt;

    }

}