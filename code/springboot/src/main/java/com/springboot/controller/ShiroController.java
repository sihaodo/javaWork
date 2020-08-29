package com.springboot.controller;

import com.springboot.entity.EmpEntity;
import com.springboot.entity.Result;
import com.springboot.entity.User;
import com.springboot.service.EmpService;
import com.springboot.service.UserService;
import com.springboot.util.JwtUtil;
import com.springboot.util.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShiroController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmpService empService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request, Model model) {
        // 根据用户名和密码创建 Token
        User sysuser = userService.getUser(user.getUsername());
        Result<Object> result = new Result<>();
        if(sysuser != null){
            String passcode = this.compute(user.getPasscode(),sysuser.getSalt());
            if(passcode.equals(sysuser.getPasscode())){
                String token = JwtUtil.sign(user.getUsername());
                Map<String,Object> map = new HashMap<>();
                map.put("token",token);
                map.put("user",sysuser);
                result.setData(map);
                return result;
            }
        }
        result.setErrorMsg("error");
        return result;

    }

    @GetMapping("/getEmp")
    public R getEmp(){
        List<EmpEntity> list = empService.getEmpList();
        R r = new R();
        r.setResult(list);
        return r.ok();
    }

    private String compute(String passcode,String salt){
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        String hashAlgorithmName = "MD5";//加密方式
        //1024指的是加密的次数
        Object simpleHash = new SimpleHash(hashAlgorithmName, passcode,
                credentialsSalt, 1024);
        return simpleHash.toString();
    }

    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }
}
