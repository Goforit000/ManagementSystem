package com.zhq.demo.biz;

import com.zhq.demo.entity.User;
import com.zhq.demo.entity.User;
import com.zhq.demo.mapper.StuMapper;
import com.zhq.demo.mapper.UserMapper;
import com.zhq.demo.util.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBiz {
    static int i =0;
    @Autowired
    private UserMapper mapper;

    public User getUserTel(String  tel ) {
        return mapper.selectUserByTel(tel);
    }
    public boolean addUser(User user){
        return mapper.insertUser(user)>0;
    }
    public boolean removeUser(String  tel){
        return mapper.deleteUserByTel(tel)>0;
    }

    public User checkLogin(User user){
        User dbUser = mapper.selectUserByTel(user.getTel());
        if(dbUser!=null && dbUser.getLoginPwd().equals(user.getLoginPwd())){
            System.out.println(dbUser.getTel());
            System.out.println(dbUser.getLoginPwd());

            dbUser.setLoginPwd(null);
            return dbUser;
        }else {
            throw new MyException("登录失败，电话号码不存在或者密码错误");
        }
    }

    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}
