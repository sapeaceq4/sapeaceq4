package org.rohit.spring;

import org.rohit.spring.dao.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class RunSpring {

	public static void main(String[] args) {
		ApplicationContext cxt = new FileSystemXmlApplicationContext("D:/Context.xml");
		EmployeeDao empdao= (EmployeeDao) cxt.getBean("employeeDao");
		Employee emp = new Employee();
		emp.setId(126952);
		emp.setName("Rohit");
		empdao.saveEmp(emp);
	}
}
