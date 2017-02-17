package jdbc_training.jdbc_training.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspects {
	
	@Pointcut("execution(* jdbc_training.jdbc_training.dao.EmployeeDaoImpl.saveEmployee(..))")
	private void pointCutRef(){}
	
	@Before("pointCutRef()")
	public void before(){
		System.out.println("Before");
	}
	
	@After("pointCutRef()")
	public void after(){
		System.out.println("After");
	}
	
	@Around("pointCutRef()")
	public void around(ProceedingJoinPoint p) throws Throwable{
		System.out.println("Around");
		
		p.proceed();
	}
	
	@AfterReturning(pointcut = "pointCutRef()", returning= "retVal")
	public void onReturn(Object retVal){
		System.out.println("AfterReturning");
	}
	
	@AfterThrowing(pointcut = "pointCutRef()", throwing="ex")
	public void onException(Exception ex){
		System.out.println("AfterThrowing");
	}
			

}
