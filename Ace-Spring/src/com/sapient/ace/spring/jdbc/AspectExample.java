package com.sapient.ace.spring.jdbc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectExample {

	@Before("execution(* com.sapient.ace.spring.jdbc.EmployeeDao.updateEmployee(..))")
	public void beforeUpdate() {
		System.out.println("Before updating the employee table");
	}

	@After("execution(* com.sapient.ace.spring.jdbc.EmployeeDao.updateEmployee(..))")
	public void afterUpdate() {
		System.out.println("After updating the employee table.");
	}

	@Around("execution(* com.sapient.ace.spring.jdbc.EmployeeDao.saveEmployee(..))")
	public void aroundSave(ProceedingJoinPoint call) throws Throwable {
		call.proceed();
		System.out.println("Around save");
	}

}
