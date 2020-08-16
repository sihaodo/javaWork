package com.springboot.controller;

import com.springboot.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ShiroController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpServletRequest request) {
        // 根据用户名和密码创建 Token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPasscode());
        // 获取 subject 认证主体
        Subject subject = SecurityUtils.getSubject();
        try{
            // 开始认证，这一步会跳到我们自定义的 Realm 中
            subject.login(token);
            request.getSession().setAttribute("user", user);
            System.out.println(subject);
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            request.getSession().setAttribute("user", user);
            request.setAttribute("error", "用户名或密码错误！");
            return "login";
        }
    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("where","admin");
        return "success";
    }

    @GetMapping("/compute")
    public String compute(Model model){
        ByteSource credentialsSalt01 = ByteSource.Util.bytes("lisi");
        Object salt = null;//盐值
        Object credential = "123456";//密码
        String hashAlgorithmName = "MD5";//加密方式
        //1024指的是加密的次数
        Object simpleHash = new SimpleHash(hashAlgorithmName, credential,
                credentialsSalt01, 1024);
        System.out.println("加密后的值----->" + simpleHash);
        return "success";
    }

    @GetMapping("/student")
    public String student(Model model){
        model.addAttribute("where","student");
        return "success";
    }

    @GetMapping("/teacher")
    public String teacher(Model model){
        model.addAttribute("where","teacher");
        return "success";
    }

    @GetMapping("/unauth")
    public String unauth(Model model){
        model.addAttribute("where","unauth");
        return "unauth";
    }

    @GetMapping("/success")
    public String success(Model model){
        model.addAttribute("where","success");
        return "success";
    }

    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }
}
