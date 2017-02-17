package com.sapient.ace.spring.jdbc.dao;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Ravdeep Singh on 2/16/2017.
 */

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.sapient.ace.spring.jdbc.dao.EmployeeDao.*(..))")
    public void beforeExecution() {
        System.out.println("Execution started");
    }

    @After("execution(* com.sapient.ace.spring.jdbc.dao.EmployeeDao.*(..))")
    public void afterExecution() {
        System.out.println("Execution completed");
    }

    @AfterThrowing(pointcut = "execution(* com.sapient.ace.spring.jdbc.dao.EmployeeDao.*(..))", throwing = "exception")
    public void onException(Exception exception) {
        System.out.println("Error occurred"+ exception.getMessage());

    }
    @Around("execution(* com.sapient.ace.spring.jdbc.dao.EmployeeDao.*(..))")
    public Object aroundExecution(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Before invoking method Around");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("throwing except");
            e.printStackTrace();
        }
        System.out.println("After invoking method Around. Return value="+value);
        return value;
    }


}
