//package com.zhq.demo.biz;
//
//import com.zhq.demo.entity.Course;
//import com.zhq.demo.mapper.CourseMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CourseBiz {
//    @Autowired//由Spring创建对象并通过setter方法注入
//    private CourseMapper mapper;
//    public List<Course> getCourseList(){
//        return mapper.selectCourses();
//    }
//
//    public Course getCourseById(int id ) {
//        return mapper.selectCourseById(id);
//    }
//    public List<Course> getCourseByName(String name ) {
//        return mapper.selectCourseByName(name);
//    }
//
//    public boolean addCourse(Course Course){
//        return mapper.insertCourse(Course)>0;
//    }
//    public boolean removeCourse(int id){
//        return mapper.deleteCourseById(id)>0;
//    }
//    public boolean updateCourse(Course stu){
//        int result =  mapper.updateCourseById(stu);
//        return result>0;
//    }
//
//    public void setMapper(CourseMapper mapper) {
//
//        this.mapper = mapper;
//    }
//
//    public List<Course> getCourseList(int page, int size) {
//        int offset = (page - 1) * size;
//        return mapper.selectCoursesWithPagination(offset, size);
//    }
//
//    public int getTotalCount() {
//        return mapper.selectTotalCount();
//    }
//}
package com.zhq.demo.biz;

import com.zhq.demo.entity.Course;
import com.zhq.demo.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseBiz {

    @Autowired
    private CourseMapper mapper;

    public List<Course> getCourseById(String id) {
        return mapper.selectCourseById(id);
    }

    public List<Course> getCourseByName(String name) {
        return mapper.selectCourseByName(name);
    }

    public List<Course> getCourseByType(String type) {
        return mapper.selectCourseByType(type);
    }

    public List<Course> getCourseCon(String name,String type) {
        System.out.println("Biz:"+name);
        return mapper.selectCourseCon(name,type);
    }

    public boolean addCourse(Course Course) {
        return mapper.insertCourse(Course) > 0;
    }

    public boolean removeCourse(String id) {
        return mapper.deleteCourseById(id) > 0;
    }

    public boolean updateCourse(Course course) {
        int result = mapper.updateCourseById(course);
        return result > 0;
    }

    public void setMapper(CourseMapper mapper) {
        this.mapper = mapper;
    }

    public List<Course> getCourseList(int page, int size) {
        int offset = (page - 1) * size;
        return mapper.selectCoursesWithPagination(offset, size);
    }

    public int getTotalCount() {
        return mapper.selectTotalCount();
    }
}
