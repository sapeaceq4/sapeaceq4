package com.sapient.ACE.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PersonDAOAspect {

	@Pointcut("execution(* com.sapient.ACE.DAO.PersonDAO.savePerson(..))")
	private void ponitRef(){
		
	}
	
	@Before("ponitRef()")
	public void doBeforetask() {
		// TODO Auto-generated method stub
		System.out.println("Hi Before");
	}
	
	@After("ponitRef()")
	public void doAftertask() {
		// TODO Auto-generated method stub
		System.out.println("Hi After");
	}
	
	@Around("ponitRef()")
	public void doAroundtask(ProceedingJoinPoint p) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Hi Around");
		p.proceed();
		
	}
	
}
