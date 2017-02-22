package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringExerLabApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringExerLabApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("data-source.xml");
		Employee emp = new Employee("test", "Gurgaon");
		IEmployeeDao dao = context.getBean("employeeDao",IEmployeeDao.class);
		dao.insert(emp);
	}
}
