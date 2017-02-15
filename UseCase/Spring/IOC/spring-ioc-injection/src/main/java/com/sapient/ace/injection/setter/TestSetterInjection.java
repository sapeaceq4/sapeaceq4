package com.sapient.ace.injection.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetterInjection {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-setter.xml");
		
		Student student = context.getBean("student", Student.class);
		
		System.out.println(student.getName());

	}

}
