package com.zhq.demo.interceptor;

import com.zhq.demo.entity.User;
import com.zhq.demo.util.MyException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //执行Controller之前，调用此方法，
        //如果返回true则继续执行Controller，否则不再访问Controller
            System.out.println("Begin Interceptor");
            System.out.println("Session ID: " + request.getSession().getId());
            Object user = request.getSession().getAttribute("login_user");
            System.out.println("login_user: " + user);
            if (user == null) {
                throw new MyException("错误，未登录或登录失效，请重新登录后再执行");
            }
            return true;
        }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //执行Controller之后，调用此方法
        System.out.println("end Interceptor");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //本次请求完全结束后调用此方法
    }
}
