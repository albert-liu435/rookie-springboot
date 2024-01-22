package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Class StudentMapper
 * @Description https://www.jb51.net/database/2965575gx.htm
 * @Author rookie
 * @Date 2024/1/17 16:47
 * @Version 1.0
 */
@Mapper
public interface StudentMapper {

//    常用的储存时间/日期的类型：
//
//    DATE：仅用于存储日期值（年、月、日），格式为'YYYY-MM-DD'。
//    TIME：仅用于存储时间值（小时、分钟、秒），格式为'HH:MM:SS'。
//    DATETIME：用于同时存储日期和时间值，格式为'YYYY-MM-DD HH:MM:SS'。
//    TIMESTAMP：用于存储日期和时间戳值，格式同 DATETIME 一致，但其支持更广泛的时间范围。
//            ————————————————
//    版权声明：本文为CSDN博主「華同学.」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//    原文链接：https://blog.csdn.net/weixin_50769390/article/details/130855661


    /**
     * 当接口的方法的参数只有一个，并且参数的数据类型都是简单类型
     * 根据id、name、birth、sex查询
     */
    List<Student> selectById(Long id);

    List<Student> selectByName(String name);

    List<Student> selectByBirth(String birth);

    List<Student> selectBySex(Character sex);


    /**
     * 保存学生信息，通过Map参数，以下是单个参数，但是参数的类型不是简单类型，是Map集合
     *
     * @param map
     * @return
     */
    int insertStudentByMap(Map<String, Object> map);


    /**
     * 保存学生信息，通过POJO参数，Student是单个参数，但不是简单类型
     *
     * @param student
     * @return
     */
    int insertStudentByPOJO(Student student);


    /**
     * 这是多参数查询
     * 根据name和sex查询Student信息
     * 如果是多个参数的话，MyBatis框架底层的做法如下：
     * MyBatis框架会自动创建一个Map集合并且Map集合是以这种方式存储参数的
     * map.put("arg0",name);/map.put("param1",name);
     * map.put("arg1",sex);/map.put("param2",sex);
     * <p>
     * 使用Param注解指定Sql语句中的#{}命名
     *
     * @param name
     * @param sex
     * @return
     */
    List<Student> selectByNameAndSex(
            @Param("nnn") String name,
            @Param("sss") Character sex);


    /**
     * 根据id获取学生信息，同时获取学生关联的班级信息
     *
     * @param id 学生的id
     * @return 学生对象，但是学生对象当中含有班级对象
     */
    Student selectByNewId(Integer id);


    /**
     * 一条SQL语句，association
     *
     * @param id
     * @return
     */
    Student selectByIdAssociation(Integer id);


    /**
     * 分步查询第一步：先根据学生的sid查询学生的信息
     * @param id
     * @return
     */
    Student selectByIdStep1(Integer id);



    /**
     * 根据班级编号查询学生信息
     * @param cid
     * @return
     */
    List<Student> selectByStep2(Integer sid);

}
