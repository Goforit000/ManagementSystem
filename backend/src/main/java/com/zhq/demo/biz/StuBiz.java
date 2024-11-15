package com.zhq.demo.biz;

import com.zhq.demo.entity.Student;
import com.zhq.demo.mapper.StuMapper;
import com.zhq.demo.mapper.StuMapper;
import com.zhq.demo.util.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuBiz {
    @Autowired//由Spring创建对象并通过setter方法注入
    private StuMapper mapper;
    public List<Student> getStuList(){
        return mapper.selectStudents();
    }

    public List<Student> getStuById(int id ) {
        return mapper.selectStuById(id);
    }

    public boolean addStu(Student Stu){
        return mapper.insertStu(Stu)>0;
    }
    public boolean removeStu(int id){
        return mapper.deleteStuById(id)>0;
    }
    public boolean updateStu(Student stu){
        int result =  mapper.updateStuById(stu);
        return result>0;
    }

    public void setMapper(StuMapper mapper) {

        this.mapper = mapper;
    }

    public List<Student> getStuList(int page, int size) {
        int offset = (page - 1) * size;
        return mapper.selectStudentsWithPagination(offset, size);
    }
    public int getTotalCount() {
        return mapper.selectTotalCount();
    }
}
