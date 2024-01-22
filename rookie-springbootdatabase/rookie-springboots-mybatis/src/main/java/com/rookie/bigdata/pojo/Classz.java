package com.rookie.bigdata.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Class Class
 * @Description
 * @Author rookie
 * @Date 2024/1/19 11:47
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Classz { //教室类
    private Integer cid;
    private String cname;

    private List<Student> studentList;
}
