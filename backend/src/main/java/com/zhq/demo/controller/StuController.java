package com.zhq.demo.controller;

import com.zhq.demo.biz.StuBiz;
import com.zhq.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller//声明这个类是spring项目中的控制器类（相当于Servlet）
@RestController//Controller+ResponseBody
@RequestMapping("/stu")
public class StuController {
    @Autowired
    private StuBiz biz;
    @RequestMapping("/list")
    public Map findAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        List<Student> list = biz.getStuList(page, size);
        int total = biz.getTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("isOk", true);
        map.put("Students", list);
        map.put("total", total);
        map.put("msg", "查询成功");
        return map;
    }

    @RequestMapping("/add")
    public Map add(Student Stu){
        boolean isOk = biz.addStu(Stu);
        Map map = new HashMap();
        if (isOk){
            map.put("isOk",true);
            map.put("msg","添加成功");
        }else {
            map.put("isOk",false);
            map.put("msg","添加失败");
        }
        return  map;
    }

    @RequestMapping("/del")
    public Map del(int id){
        boolean isOk = biz.removeStu(id);
        Map map = new HashMap();
        if (isOk){
            map.put("isOk",true);
            map.put("msg","删除成功");
        }else {
            map.put("isOk",false);
            map.put("msg","删除失败");
        }
        return  map;
    }

    @RequestMapping("/findId")
    public Map find(int id){
        List<Student> student = biz.getStuById(id);
        Map map = new HashMap();
        System.out.println(student);
        if (!student.isEmpty()){
            map.put("isOk",true);
            map.put("msg","查询成功");
            map.put("Students",student);
        }else {
            map.put("isOk",false);
            map.put("msg","查无此人");
        }
        return  map;
    }
//    @RequestMapping("/findName")
//    public Map find(String name){
//        List<Student> students = biz.getStuByName(name);
//        Map map = new HashMap();
//        if (students.isEmpty()){
//            map.put("isOk",true);
//            map.put("msg","没有叫这个名字的学生");
//        }else {
//            map.put("isOk",false);
//            map.put("msg","查询成功");
//            map.put("Students", students);
//        }
//        return  map;
//    }
    @RequestMapping("/update")
    public Map update(Student student){
        boolean isOk = biz.updateStu(student);
        Map map = new HashMap();
        if (isOk){
            map.put("isOk",true);
            map.put("msg","修改成功");
        }else {
            map.put("isOk",false);
            map.put("msg","修改失败");
        }
        return  map;
    }

    public void setBiz(StuBiz biz) {
        this.biz = biz;
    }
}

