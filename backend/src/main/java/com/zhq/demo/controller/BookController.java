package com.zhq.demo.controller;

import com.zhq.demo.biz.BookBiz;
import com.zhq.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookBiz biz;

    @RequestMapping("/list")
    public Map findAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        List<Book> list = biz.getBookList(page, size);
        int total = biz.getTotalCount();
        Map<String, Object> map = new HashMap<>();
        map.put("isOk", true);
        map.put("Books", list);
        map.put("total", total);
        map.put("msg", "查询成功");
        return map;
    }

    @RequestMapping("/add")
    public Map add(Book Book) {
        boolean isOk = biz.addBook(Book);
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
        System.out.println("Attempting to delete book with ID: " + id);
        boolean result = biz.removeBook(id);
        Map map = new HashMap();
        if (result) {
            map.put("isOk", true);
            map.put("msg", "删除成功");
            System.out.println("Book with ID " + id + " deleted successfully.");
        } else {
            map.put("isOk", false);
            map.put("msg", "没有找到对应的课程");
            System.out.println("No book found with ID " + id + ".");
        }
        return map;
    }
    @RequestMapping("/findId")
    public Map findById(String id){
        List<Book> book = biz.getBookById(id);
        Map map = new HashMap();
        if (book!=null){
            map.put("isOk",true);
            map.put("msg","查询成功");
            map.put("Books",book);
        }else {
            map.put("isOk",false);
            map.put("msg","查寻失败");
        }
        return  map;
    }

    @RequestMapping("/findName")
    public Map findByName(String name) {
        List<Book> books = biz.getBookByName(name);
        Map map = new HashMap();
        if (books.isEmpty()) {
            map.put("isOk", false);
            map.put("msg", "没有叫这个名字的课程");
        } else {
            map.put("isOk", true);
            map.put("msg", "查询成功");
            map.put("Books", books);
        }
        return map;
    }
    @RequestMapping("/findByType")
    public Map findByType(String type) {
        List<Book> books = biz.getBookByType(type);
        Map map = new HashMap();
        if (books.isEmpty()) {
            map.put("isOk", false);
            map.put("msg", "没有符合条件的课程");
        } else {
            map.put("isOk", true);
            map.put("msg", "查询成功");
            map.put("Books", books);
        }
        return map;
    }

    @RequestMapping("/findCon")
    public Map findCon(String name, String type) {
        System.out.println(name+type);
        List<Book> books = biz.getBookCon(name,type);
        System.out.println(books);
        Map map = new HashMap();
        if (books.isEmpty()) {
            map.put("isOk", false);
            map.put("msg", "没有符合条件的课程");
        } else {
            map.put("isOk", true);
            map.put("msg", "查询成功");
            map.put("Books", books);
        }
        return map;
    }

    @RequestMapping("/update")
    public Map update(Book book) {
        boolean isOk = biz.updateBook(book);
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

    public void setBiz(BookBiz biz) {
        this.biz = biz;
    }
}

