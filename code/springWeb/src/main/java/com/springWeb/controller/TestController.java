package com.springWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @GetMapping("/cookie")
    public String cookie(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("hi"));
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            System.out.println(cookie.getName());
        }
        return "index";
    }
}
