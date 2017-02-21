package org.rohit.spring.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class EmployeeAOP {
	
	public void runBefor()
	{
		System.out.println("Befor");
	}

	public void runAfter()
	{
		System.out.println("After");
	}
	public void afterReturning()
	{
		System.out.println("After Returning");
	}
	public void onThrow()
	{
		System.out.println("On Exception");
	}
	
	public void around(ProceedingJoinPoint p)
	{
		System.out.println("around");
		try {
			p.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
