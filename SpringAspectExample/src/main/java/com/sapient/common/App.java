package com.sapient.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.customer.model.Employee;
import com.sapient.service.EmployeeOperationManager;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    	 
    	EmployeeOperationManager empManager = (EmployeeOperationManager) context.getBean("empService");
        Employee empToCreate = new Employee(6, "Ram",29);
        
        
        empManager.addNewEmployee(empToCreate);
        
    }
}
