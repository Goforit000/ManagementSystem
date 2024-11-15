//package com.zhq.demo.mapper;
//
//import com.zhq.demo.entity.Course;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//
//public interface CourseMapper {
//    @Select("select * from t_course")
//    List<Course> selectCourses();
//
//    @Select("select * from t_course where courseId=#{id}")
//    Course selectCourseById(int id);
//    @Select("SELECT * FROM t_course WHERE courseName LIKE CONCAT('%', #{name}, '%')")
//    List<Course> selectCourseByName(String name);
//
//    @Insert("insert into t_course values (#{courseId},#{courseName},#{courseType},#{courseNum})")
//    int insertCourse(Course course);
//
//    @Delete("delete from t_course where courseId=#{id}")
//    int deleteCourseById(int id);
//    @Update("update t_course set courseId=#{courseId},courseName=#{courseName},courseType=#{courseType},courseNum=#{courseNum} where courseId=#{courseId}")
//    int updateCourseById(Course course);
//
//    @Select("select count(*) from t_course")
//    int selectTotalCount();
//
//    @Select("select * from t_course limit #{offset}, #{size}")
//    List<Course> selectCoursesWithPagination(@Param("offset") int offset, @Param("size") int size);
//
//}
package com.zhq.demo.mapper;

import com.zhq.demo.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourseMapper {
    @Select("select * from t_course")
    List<Course> selectCourses();
    @Select("SELECT * FROM t_course WHERE courseName LIKE CONCAT('%', #{name}, '%')")
    List<Course> selectCourseByName(String name);
    @Select("SELECT * FROM t_course WHERE courseId = #{id}")
    List<Course> selectCourseById(String id);
    @Select("SELECT * FROM t_course WHERE courseType = #{type}")
    List<Course> selectCourseByType(String type);

    @Select("SELECT * FROM t_course WHERE courseName LIKE CONCAT('%', #{name}, '%') AND courseType = #{type}")
    List<Course> selectCourseCon(@Param("name") String name, @Param("type") String type);

    @Insert("insert into t_course values (#{courseId},#{courseName},#{courseType},#{courseNum})")
    int insertCourse(Course course);

    @Delete("delete from t_course where courseId=#{id}")
    int deleteCourseById(String id);

    @Update("update t_course set courseId=#{courseId},courseName=#{courseName},courseType=#{courseType},courseNum=#{courseNum} where courseId=#{courseId}")
    int updateCourseById(Course course);

    @Select("select count(*) from t_course")
    int selectTotalCount();

    @Select("select * from t_course limit #{offset}, #{size}")
    List<Course> selectCoursesWithPagination(@Param("offset") int offset, @Param("size") int size);
}

