package com.sapient.annotation;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class);
    
    public static void main(String args[]){
	logger.info("Message!");
	ApplicationContext appContext = new ClassPathXmlApplicationContext("com/sapient/annotation/spring-context.xml");
	/*Order order = appContext.getBean("order", Order.class);
	order.execute();*/
	Employee employee = new Employee(new BigDecimal(1008),"Arvind","IT");
	EmployeeDao employeeDao=appContext.getBean("employeeDao", EmployeeDao.class);
	employeeDao.saveEmployee(employee);
	List<Employee> list=employeeDao.getEmployees();
	for (Employee employee2 : list) {
		System.out.println(employee2.getEmpId());
		System.out.println(employee2.getEmpName());
		System.out.println(employee2.getDept());
	}
	System.out.println("Done");
    }
}
