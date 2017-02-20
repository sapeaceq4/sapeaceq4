package com.sapient.ACE.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {


		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"ApplicationContext.xml");
		ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext(
				"ApplicationContext2.xml");
		Person app = (Person) context.getBean("person");
		System.out.println(app.toString());
		Person appp = (Person) context2.getBean("person");
		System.out.println(appp.toString());
		Address app1 = (Address) context.getBean("person1");
		System.out.println(app1);
		Address app2 = (Address) context2.getBean("person1");
		System.out.println(app1);
		
		Address add = (Address) context.getBean("address1");
		System.out.println(add);
		Address add2 = (Address) context.getBean("address1");
		System.out.println(add2);
		
		context.close();
		
	}

}
