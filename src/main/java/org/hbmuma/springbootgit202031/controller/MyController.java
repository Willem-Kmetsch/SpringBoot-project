package org.hbmuma.springbootgit202031.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;
import java.util.Map;

@Controller
public class MyController {
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
            return "index";
        } else{
            map.put("msg","用户名密码错误");
            return "login";
        }
    }

}
