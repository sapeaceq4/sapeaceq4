package org.om.aec.spring.jdbc;

import org.om.aec.spring.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;

public class EmployeeClient
{
	public static void main(String[] args)
	{
		ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
		EmployeeService employeeService = applicationContext.getBean("employeeManager",
				EmployeeService.class);

		//employeeService.createEmployee(new Employee(7, "Ram", "Singh"));
		employeeService.updateEmployee(new Employee(7, "Ram", "Singh"));
		//System.out.println(employeeService.getEmployeeById(23));
		//System.out.println(employeeService.deleteEmployee(3));
		//System.out.println(employeeService.getAllEmployees());
	}
}
