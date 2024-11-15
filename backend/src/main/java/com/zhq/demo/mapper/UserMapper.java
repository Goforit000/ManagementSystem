package com.zhq.demo.mapper;

import com.zhq.demo.entity.Student;
import com.zhq.demo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface UserMapper {
    @Select("select * from t_user where tel=#{tel}")
    public User selectUserByTel(String tel);
    @Insert("insert into t_user values (null,#{tel},#{loginPwd},#{userName})")
    public int insertUser(User user);

    @Delete("delete from t_user where tel=#{tel}")
    int deleteUserByTel(String tel);
}
