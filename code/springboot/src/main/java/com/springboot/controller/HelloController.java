package com.springboot.controller;

import com.springboot.entity.EmpEntity;
import com.springboot.service.EmpService;
import com.springboot.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    private EmpService empService;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world!";
    }

    @GetMapping("/getEmp")
    @ResponseBody
    public String getEmp(){
        EmpEntity empEntity = empService.getOneEmp();
        return empEntity.toString();
    }

    @GetMapping("/redis")
    public String  redis(){
        redisUtil.set("sihao","dong");
        String item = (String) redisUtil.get("sihao");
        System.out.println(item);
        Map<String,Object> map = new HashMap<>();
        map.put("11","aa");
        map.put("22","bb");
        redisUtil.hmset("lalala",map);
        return "redirect:/hello";

    }

}
