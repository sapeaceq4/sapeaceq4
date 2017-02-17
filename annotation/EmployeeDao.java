package com.sapient.annotation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface EmployeeDao {
	
	@Transactional
	public void saveEmployee(Employee employee);
	public List<Employee> getEmployees();
}
