//package com.zhq.demo.biz;
//
//import com.zhq.demo.entity.Book;
//import com.zhq.demo.mapper.BookMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookBiz {
//    @Autowired//由Spring创建对象并通过setter方法注入
//    private BookMapper mapper;
//    public List<Book> getBookList(){
//        return mapper.selectBooks();
//    }
//
//    public Book getBookById(int id ) {
//        return mapper.selectBookById(id);
//    }
//    public List<Book> getBookByName(String name ) {
//        return mapper.selectBookByName(name);
//    }
//
//    public boolean addBook(Book Book){
//        return mapper.insertBook(Book)>0;
//    }
//    public boolean removeBook(int id){
//        return mapper.deleteBookById(id)>0;
//    }
//    public boolean updateBook(Book stu){
//        int result =  mapper.updateBookById(stu);
//        return result>0;
//    }
//
//    public void setMapper(BookMapper mapper) {
//
//        this.mapper = mapper;
//    }
//
//    public List<Book> getBookList(int page, int size) {
//        int offset = (page - 1) * size;
//        return mapper.selectBooksWithPagination(offset, size);
//    }
//
//    public int getTotalCount() {
//        return mapper.selectTotalCount();
//    }
//}
package com.zhq.demo.biz;

import com.zhq.demo.entity.Book;
import com.zhq.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBiz {

    @Autowired
    private BookMapper mapper;

    public List<Book> getBookById(String id) {
        return mapper.selectBookById(id);
    }

    public List<Book> getBookByName(String name) {
        return mapper.selectBookByName(name);
    }

    public List<Book> getBookByType(String type) {
        return mapper.selectBookByType(type);
    }

    public List<Book> getBookCon(String name,String type) {
        System.out.println("Biz:"+name);
        return mapper.selectBookCon(name,type);
    }

    public boolean addBook(Book Book) {
        return mapper.insertBook(Book) > 0;
    }

    public boolean removeBook(String id) {
        return mapper.deleteBookById(id) > 0;
    }

    public boolean updateBook(Book book) {
        int result = mapper.updateBookById(book);
        return result > 0;
    }

    public void setMapper(BookMapper mapper) {
        this.mapper = mapper;
    }

    public List<Book> getBookList(int page, int size) {
        int offset = (page - 1) * size;
        return mapper.selectBooksWithPagination(offset, size);
    }

    public int getTotalCount() {
        return mapper.selectTotalCount();
    }
}
