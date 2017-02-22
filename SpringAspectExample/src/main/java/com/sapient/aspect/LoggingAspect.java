package com.sapient.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* com.sapient.service.EmployeeOperationManager.addNewEmployee(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logBefore()");
	}
	
	@After("execution(* com.sapient.service.EmployeeOperationManager.addNewEmployee(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logAfter()");
	}
	
	@Around("execution(* com.sapient.service.EmployeeOperationManager.addNewEmployee(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("LoggingAspect.logAround()");
		joinPoint.proceed();
	}

}