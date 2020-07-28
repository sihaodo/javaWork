package com.springWeb.controller;

import com.springWeb.entity.Dept;
import com.springWeb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/{deptno}")
    public String dept(@PathVariable int deptno, Model model){
        Dept dept = deptService.selectDept(deptno);
        model.addAttribute("dept",dept);
        return "dept";
    }

    @GetMapping("/adddept")
    public String adddept(){
        return "adddept";
    }

    @PostMapping(value = "/dept")
    public String dept(Dept dept) throws Exception{
        dept.setPic(dept.getPhoto().getBytes());
        int result  = deptService.addDept(dept);
        return "/index";
    }
}
