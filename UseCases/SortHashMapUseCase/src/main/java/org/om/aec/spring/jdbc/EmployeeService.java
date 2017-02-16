package org.om.aec.spring.jdbc;

import java.util.List;

public interface EmployeeService 
{
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee deleteEmployee(int id);
	Employee getEmployeeById(int id);
	List<Employee> getAllEmployees();
}
