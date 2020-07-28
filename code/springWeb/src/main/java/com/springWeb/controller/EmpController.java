package com.springWeb.controller;

import com.springWeb.entity.Emp;
import com.springWeb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emp/{id}")
    public String select(@PathVariable int id, Model model){
        Emp emp = empService.select(id);
        model.addAttribute("emp",emp);
        return "emp";
    }

}
