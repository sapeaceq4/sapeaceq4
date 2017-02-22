package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LoggingAspect {
	
	@Pointcut("execution(* com.example.EmployeeDao.insert(..))")
	public void pointcutRef(){
		
	}
	
	@Before("pointcutRef()")
	public void beforeInsert(){
		System.out.println("this is before insertion of record in DB");
	}
	
	
	@After("pointcutRef()")
	public void afterInsert(){
		System.out.println("this is After insertion of record in DB");
	}

	
	@Around("pointcutRef()")
	public void aroundInsert(ProceedingJoinPoint pt){
		System.out.println("started Around ---------------------------");
//		EmployeeDao obj = (EmployeeDao) pt.getTarget();
//		Employee args = (Employee)pt.getArgs()[0];
		try {
			pt.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("this is Around insertion of record in DB");
	}

}
