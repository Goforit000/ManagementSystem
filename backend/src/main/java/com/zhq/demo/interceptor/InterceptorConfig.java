package com.zhq.demo.interceptor;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    public void setLoginInterceptor(LoginInterceptor loginInterceptor) {

        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/stu/*")
        .addPathPatterns("/Course/*").addPathPatterns("/Book/*").addPathPatterns("/user/*")
        .excludePathPatterns("/user/login","/user/register");
    }
}
