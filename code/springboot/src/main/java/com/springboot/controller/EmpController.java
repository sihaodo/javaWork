package com.springboot.controller;

import com.springboot.entity.EmpEntity;
import com.springboot.entity.Result;
import com.springboot.service.EmpService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;


    @RequiresAuthentication
    @GetMapping("/getEmp")
    public Result<?> getEmp(){
        List<EmpEntity> list = empService.getEmpList();
        Result<List<EmpEntity>> result = new Result<>();
        result.setData(list);
        return result;
    }
}
