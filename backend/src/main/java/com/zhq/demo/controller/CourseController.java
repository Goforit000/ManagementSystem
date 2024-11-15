package com.zhq.demo.controller;

import com.zhq.demo.biz.CourseBiz;
import com.zhq.demo.entity.Course;
import com.zhq.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseBiz biz;

    @RequestMapping("/list")
    public Map findAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        List<Course> list = biz.getCourseList(page, size);
        int total = biz.getTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("isOk", true);
        map.put("Courses", list);
        map.put("total", total);
        map.put("msg", "查询成功");
        return map;
    }

    @RequestMapping("/add")
    public Map add(Course Course) {
        boolean isOk = biz.addCourse(Course);
        Map map = new HashMap();
        if (isOk) {
            map.put("isOk", true);
            map.put("msg", "添加成功");
        } else {
            map.put("isOk", false);
            map.put("msg", "添加失败");
        }
        return map;
    }

    @RequestMapping("/del")
    public Map del(String id) {
        System.out.println("Attempting to delete course with ID: " + id);
        boolean result = biz.removeCourse(id);
        Map map = new HashMap();
        if (result) {
            map.put("isOk", true);
            map.put("msg", "删除成功");
            System.out.println("Course with ID " + id + " deleted successfully.");
        } else {
            map.put("isOk", false);
            map.put("msg", "没有找到对应的课程");
            System.out.println("No course found with ID " + id + ".");
        }
        return map;
    }
    @RequestMapping("/findId")
    public Map findById(String id){
        List<Course> course = biz.getCourseById(id);
        Map map = new HashMap();
        if (course!=null){
            map.put("isOk",true);
            map.put("msg","查询成功");
            map.put("Courses",course);
        }else {
            map.put("isOk",false);
            map.put("msg","查寻失败");
        }
        return  map;
    }

    @RequestMapping("/findName")
    public Map findByName(String name) {
        List<Course> courses = biz.getCourseByName(name);
        Map map = new HashMap();
        if (courses.isEmpty()) {
            map.put("isOk", false);
            map.put("msg", "没有叫这个名字的课程");
        } else {
            map.put("isOk", true);
            map.put("msg", "查询成功");
            map.put("Courses", courses);
        }
        return map;
    }
    @RequestMapping("/findByType")
    public Map findByType(String type) {
        List<Course> courses = biz.getCourseByType(type);
        Map map = new HashMap();
        if (courses.isEmpty()) {
            map.put("isOk", false);
            map.put("msg", "没有符合条件的课程");
        } else {
            map.put("isOk", true);
            map.put("msg", "查询成功");
            map.put("Courses", courses);
        }
        return map;
    }

    @RequestMapping("/findCon")
    public Map findCon(String name, String type) {
        System.out.println(name+type);
        List<Course> courses = biz.getCourseCon(name,type);
        System.out.println(courses);
        Map map = new HashMap();
        if (courses.isEmpty()) {
            map.put("isOk", false);
            map.put("msg", "没有符合条件的课程");
        } else {
            map.put("isOk", true);
            map.put("msg", "查询成功");
            map.put("Courses", courses);
        }
        return map;
    }

    @RequestMapping("/update")
    public Map update(Course course) {
        boolean isOk = biz.updateCourse(course);
        Map map = new HashMap();
        if (isOk) {
            map.put("isOk", true);
            map.put("msg", "修改成功");
        } else {
            map.put("isOk", false);
            map.put("msg", "修改失败");
        }
        return map;
    }

    public void setBiz(CourseBiz biz) {
        this.biz = biz;
    }
}

