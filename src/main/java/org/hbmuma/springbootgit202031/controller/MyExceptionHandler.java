package org.hbmuma.springbootgit202031.controller;

import org.hbmuma.springbootgit202031.exception.MyErrorException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

// 异常处理器
@ControllerAdvice
public class MyExceptionHandler {

    // 客户端和浏览器都返回json
//    @ResponseBody
//    @ExceptionHandler(MyErrorException.class)
//    public Map<String, Object> handlerException(Exception e){
//        Map<String, Object> map = new HashMap<>();
//        map.put("code","999");
//        map.put("msg",e.getMessage());
//        return map;
//
//    }

    @ExceptionHandler({MyErrorException.class})
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","999");
        map.put("msg","用户出错了！");
        request.setAttribute("ext",map);
        return "forward:/error";

    }
}
