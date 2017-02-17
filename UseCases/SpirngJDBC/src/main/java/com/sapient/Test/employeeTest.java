package com.sapient.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.sapient.Entity.Employee;
import com.sapient.Repo.EmployeeDao;

public class employeeTest {
   
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Employee emp = new Employee("test", 12,"sdudub");    
		EmployeeDao abc = context.getBean("empDao",EmployeeDao.class);
		abc.savePerson(emp);
	}	
}
