package org.om.aec.spring.jdbc;

import java.util.List;

import org.om.aec.spring.jdbc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeManager implements EmployeeService
{
	@Autowired
	private EmployeeDao employeeJdbcTemplate;
	
	@Override
	public Employee createEmployee(Employee employee) 
	{
		employeeJdbcTemplate.createEmployee(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) 
	{
		employeeJdbcTemplate.updateEmployee(employee);
		return employee;
	}

	@Override
	public Employee deleteEmployee(int employeeId) 
	{
		employeeJdbcTemplate.deleteEmployee(employeeId);
		return null;
	}

	@Override
	public Employee getEmployeeById(int id)
	{
		return employeeJdbcTemplate.getEmployeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		System.out.println("getAllEmployees-Enter");
		List<Employee> employees = employeeJdbcTemplate.getAllEmployees();
		System.out.println("getAllEmployees-Leave");
		return employees;
	}

}
