package com.springWeb.aspect;

import com.springWeb.annotation.Syslog;
import com.springWeb.entity.Emp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SysAspect {

    @Pointcut("@annotation(com.springWeb.annotation.Syslog)")
    public void point(){
    }

    @Around("point()")
    public Emp log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("***************");
        Emp emp = (Emp) proceedingJoinPoint.proceed();
        System.out.println("_______________");
        return emp;
    }
}
