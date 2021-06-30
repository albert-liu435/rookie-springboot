package com.rookie.bigdata.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Student
 * @Description Student  相关概念可以查看 https://segmentfault.com/a/1190000018255384
 * https://blog.csdn.net/limingcai168/article/details/85780964
 * @Author rookie
 * @Date 2021/6/29 15:56
 * @Version 1.0
 */
//document注解，表示该对象可以持久化到es中，类似数据库中的一条记录
//indexName 相当于数据库中的一个database
//shards:分片数量，每个index会被拆分为多个shard，每个shard就会存放这个index的一部分数据，这此shard会散落在多台服务器上。有了shard就可以进行横向扩展，存储更多数据，让搜索和分析等操作分布到多台服务器上去执行，提升吞吐量和性能。shard又分为replica shard和primary shard，每个shard都是一个lucene index.
//replicas:副本数量，每个服务器随时可能故障或宕机，此时shard就可以会丢失，因此可以为每一个shard创建多个replica副本。replica可以在shard故障时提供备用服务。保证数据不丢失或者丢失很少，多个replica还可以提升搜索操作的吞吐量和性能。
@Document(indexName = "student", shards = 1, replicas = 1)
public class Student implements Serializable {

    //@Id
    private Long id;

    //表示该字段是一个长整型，默认建立索引
    @Field(type = FieldType.Long)
    private Long stuNo;

    //表示该字段内容是一个文本并作为一个整体不可分，默认建立索引
    @Field(type=FieldType.Keyword)
    private String username;
    //表示该字段是一个文本，并作最大程度拆分，默认建立索引
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String address;

    //表示该字段是一个文本，不建立索引
    @Field(type = FieldType.Text, index = false)
    private String school;
    //表示该字段是一个文本，日期类型，默认不建立索引
    @Field(type = FieldType.Date,format = DateFormat.basic_date)
    private Date birthDate;

    private Integer age;

    private List<Course> courseList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStuNo() {
        return stuNo;
    }

    public void setStuNo(Long stuNo) {
        this.stuNo = stuNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
