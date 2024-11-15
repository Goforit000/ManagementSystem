package com.zhq.demo.controller;
import com.zhq.demo.biz.UserBiz;
import com.zhq.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
//@Controller//声明这个类是spring项目中的控制器类（相当于Servlet）
//@ResponseBody
@RestController//Controller+ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserBiz biz;
    @RequestMapping("/login")
    public Map login(User user, HttpSession session) {
        user = biz.checkLogin(user);
        System.out.println("User after login check: " + user);
        session.setAttribute("login_user", user);

        System.out.println("Session ID after login: " + session.getId());
        System.out.println("Session login_user: " + session.getAttribute("login_user"));
        Map<String, Object> map = new HashMap<>();
        if(user!=null){
        map.put("isOk", true);
        map.put("user", user);
        map.put("msg", "登录成功");
        }
        return map;
    }
    @PostMapping("/logout")
    public Map<String, Object> logout(HttpSession session) {
        // 清除会话中的用户信息
        session.removeAttribute("login_user");
        System.out.println("quit");

        // 返回退出成功的消息
        Map<String, Object> response = new HashMap<>();
        response.put("isOk", true);
        response.put("msg", "退出成功");
        return response;
    }

    @RequestMapping("/del")
    public Map del(String tel){
        boolean isOk = biz.removeUser(tel);
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
    @RequestMapping("/register")
    public Map add(User user){
        System.out.println(user);
        boolean isOk = biz.addUser(user);
        Map map = new HashMap();
        if (isOk){
            map.put("isOk",true);
            map.put("msg","注册成功");
        }else {
            map.put("isOk",false);
            map.put("msg","注册失败");
        }
        return  map;
    }

    public void setBiz(UserBiz biz) {
        this.biz = biz;
    }
}

