package com.zhq.demo.mapper;

import com.zhq.demo.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    @Select("select * from t_book")
    List<Book> selectBooks();
    @Select("SELECT * FROM t_book WHERE bookName LIKE CONCAT('%', #{name}, '%')")
    List<Book> selectBookByName(String name);
    @Select("SELECT * FROM t_book WHERE bookId = #{id}")
    List<Book> selectBookById(String id);
    @Select("SELECT * FROM t_book WHERE bookType = #{type}")
    List<Book> selectBookByType(String type);

    @Select("SELECT * FROM t_book WHERE bookName LIKE CONCAT('%', #{name}, '%') AND bookType = #{type}")
    List<Book> selectBookCon(@Param("name") String name, @Param("type") String type);

    @Insert("insert into t_book values (#{bookId},#{bookName},#{bookType},#{bookNum})")
    int insertBook(Book book);

    @Delete("delete from t_book where bookId=#{id}")
    int deleteBookById(String id);

    @Update("update t_book set bookId=#{bookId},bookName=#{bookName},bookType=#{bookType},bookNum=#{bookNum} where bookId=#{bookId}")
    int updateBookById(Book book);

    @Select("select count(*) from t_book")
    int selectTotalCount();

    @Select("select * from t_book limit #{offset}, #{size}")
    List<Book> selectBooksWithPagination(@Param("offset") int offset, @Param("size") int size);
}

