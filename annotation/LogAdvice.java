package com.sapient.annotation;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

    private static Logger logger = Logger.getLogger(LogAdvice.class);

    @Pointcut("execution(* com.sapient.annotation..*(..))")
    public void execute() {
    }

    @Before("execute()")
    public void before(JoinPoint jointPoint) throws Throwable {
	logger.info("Entering Method: " + jointPoint);
    }
    
    @AfterReturning("execute()")
    public void afterReturning(JoinPoint jointPoint) throws Throwable {
	logger.info("Exiting Method: " + jointPoint);
    }
}
