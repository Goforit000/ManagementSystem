package com.zhq.demo.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler
    public Map JsonError(Exception e){
        Map map = new HashMap();
        map.put("isOk",false);
        if(e instanceof MyException){
            map.put("msg",e.getMessage());
        }else {
            map.put("msg","严重的系统错误,请稍后运行");
        }

        return map;
    }
}
