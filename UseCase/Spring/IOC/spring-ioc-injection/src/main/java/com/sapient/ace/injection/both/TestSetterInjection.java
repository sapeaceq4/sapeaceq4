package com.sapient.ace.injection.both;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetterInjection {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-both.xml");
		Address address = context.getBean("myAddress", Address.class);
		// when we use both constructor and setter injection then 
		// constructor injection will overridden by setter one
		// ie we get values that is provided in setters
		System.out.println(address.getPinCode());
		
	}

}
