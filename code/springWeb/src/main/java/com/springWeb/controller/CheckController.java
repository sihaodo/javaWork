package com.springWeb.controller;

import com.springWeb.entity.User;
import com.springWeb.service.CheckService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class CheckController {

    @Autowired
    private CheckService checkService;

    @PostMapping("/check")
    public String selectUser(User params, HttpServletResponse response, HttpServletRequest request){
        User user = checkService.selectUser(params);
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("hi","ha");
            Cookie cookie = new Cookie("username",user.getUsername());
            cookie.setPath("/");
            response.addCookie(cookie);
            return "index";
        } else {
            return "login";
        }
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
