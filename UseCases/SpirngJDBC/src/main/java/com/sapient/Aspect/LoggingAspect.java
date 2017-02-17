package com.sapient.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.transaction.annotation.Transactional;

@Aspect
public class LoggingAspect {
	
	@Pointcut("execution (* com.sapient.Repo.EmployeeDao.savePerson(..))")
	public void pointCutRef(){}
	
	@Before("pointCutRef()")
	public void beforeSave()
	{
		
		System.out.println("Hey going to save employee object");
	}

	@After("pointCutRef()")
	public void afterSave()
	{
		System.out.println("Ok Done :) Employee object saved");
	}
	
	
	@Around("pointCutRef()")
	public void aroundSave(ProceedingJoinPoint call) throws Throwable
	{
		System.out.println("Lets check");
		System.out.println("Lets check one more time");
		
			int i=(Integer) call.proceed();
			System.out.println("Value of i " + i);
			System.out.println("Before the invocation of method");
		
			
		
		
	}
	
	@AfterThrowing("pointCutRef()")
	public void afterException()
	{
		System.out.println("Exception");
	}
}
