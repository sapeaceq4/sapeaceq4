package org.om.aec.spring.jdbc.dao;

import java.util.List;

import org.om.aec.spring.jdbc.Employee;

public interface EmployeeDao 
{
	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
	Employee getEmployeById(int employeeId);
	void deleteEmployee(int employeeId);
	List<Employee> getAllEmployees();
}
