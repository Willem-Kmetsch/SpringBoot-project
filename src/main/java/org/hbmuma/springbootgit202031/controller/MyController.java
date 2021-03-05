package org.hbmuma.springbootgit202031.controller;

import org.hbmuma.springbootgit202031.exception.MyErrorException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;
import java.util.Map;

@Controller
public class MyController {

    // 抛出异常
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        throw new MyErrorException();
    }

    // 到登陆页面
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }
    // 登陆
    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        Map<String, String> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            session.setAttribute("user",username);
            return "redirect:/index";
        } else{
            map.put("msg","用户名密码错误");
            return "login";
        }
    }

    // 到主页
    @RequestMapping("/index")
    public String returnToIndex(){ return "index"; }
}
