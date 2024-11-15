package com.zhq.demo.mapper;

import com.zhq.demo.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StuMapper {
    @Select("select * from t_stu")
    List<Student> selectStudents();

    @Select("select * from t_stu where stuId LIKE CONCAT('%', #{id}, '%') " +
            "or stuId=#{id}")
    List<Student> selectStuById(int id);
    @Insert("insert into t_stu values (#{stuName},#{stuId},#{stuPwd},#{phoneNum})")
    int insertStu(Student stu);

    @Delete("delete from t_stu where stuId=#{id}")
    int deleteStuById(int id);
    @Update("update t_stu set stuName=#{stuName},stuId=#{stuId}," +
            "stuPwd=#{stuPwd},phoneNum=#{phoneNum} where stuId=#{stuId}")
    int updateStuById(Student student);

    @Select("select count(*) from t_stu")
    int selectTotalCount();
    @Select("select * from t_stu limit #{offset}, #{size}")
    List<Student> selectStudentsWithPagination(@Param("offset") int offset, @Param("size") int size);

}
