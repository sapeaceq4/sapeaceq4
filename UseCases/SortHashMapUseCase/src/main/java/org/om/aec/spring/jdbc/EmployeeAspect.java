package org.om.aec.spring.jdbc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect 
{
	@Before("execution(* org.om.aec.spring.jdbc.EmployeeManager.*(..))")
	public void beforeExecution()
	{
		System.out.println("BeforeExecution-Enter/Leave");
	}
	
	@Around("execution(* org.om.aec.spring.jdbc.EmployeeManager.*(..))")
	public Object aroundExecution(ProceedingJoinPoint proceedingJoinPoint)
	{
		System.out.println("aroundExecution-Enter");
		Object value = null;
		try 
		{
			value = proceedingJoinPoint.proceed();
		} 
		catch (Throwable e) 
		{
			throw new RuntimeException(e);
		}
		
		System.out.println("aroundExecution-Leave");
		return value;
	}
	
	@After("execution(* org.om.aec.spring.jdbc.EmployeeManager.*(..))")
	public void afterExecution()
	{
		System.out.println("afterExecution-Enter");
		System.out.println("afterExecution-Leave");
	}
	
	@AfterThrowing(pointcut = "execution(* org.om.aec.spring.jdbc.EmployeeManager.*(..))", throwing = "ex")
	public void onException(Exception ex)
	{
		System.out.println("Exception raised...."+ ex.getMessage());
	}
}
