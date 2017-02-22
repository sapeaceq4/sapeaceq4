package com.sapient.service;

import com.sapient.customer.dao.EmployeeDAO;
import com.sapient.customer.model.Employee;

public class EmployeeOperationManager {

	private EmployeeDAO daoObject;

	public void setDaoObject(EmployeeDAO daoObject) {
		this.daoObject = daoObject;
	}

	public void addNewEmployee(Employee emp) {
		daoObject.updateEmpCount();
		daoObject.insert(emp);
	}

	public Employee findByEmpId(int empId) {
		return daoObject.findByEmpId(empId);
	}

	public void updateEmpByEmpId(int empId) {

		daoObject.updateEmpByEmpId(empId);
	}

}
