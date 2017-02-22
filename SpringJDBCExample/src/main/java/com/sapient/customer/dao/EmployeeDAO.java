package com.sapient.customer.dao;

import com.sapient.customer.model.Employee;

public interface EmployeeDAO 
{
	public void insert(Employee employee);
	public Employee findByEmpId(int empId);
	public void updateEmpByEmpId(int empId);
	public void updateEmpCount();
}




