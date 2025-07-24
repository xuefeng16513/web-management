package com.zidong.tlians_web_management.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
// @Aspect
public class MyAspect1 {

    @Pointcut("execution(* com.zidong.tlians_web_management.service.impl.DeptServiceImpl.*(..))")
    public void pt(){}

    @Pointcut("execution(* com.zidong.tlians_web_management.service.impl.DeptServiceImpl.deleteById(..)) || " +
            "execution(* com.zidong.tlians_web_management.service.impl.DeptServiceImpl.list(..))")
    public void pt2(){}

    @Before("pt()")
    public void before(){
        log.info("before ...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before ...");

        //调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();

        log.info("around after ...");
        return result;
    }

    @After("pt()")
    public void after(){
        log.info("after ...");
    }

    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("afterReturning ...");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("afterThrowing ...");
    }
}
