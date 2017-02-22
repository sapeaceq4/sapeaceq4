package com.sapient.service;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.sapient.customer.dao.EmployeeDAO;
import com.sapient.customer.model.Employee;

public class EmployeeOperationManager {
	
	private EmployeeDAO daoObject;
	private DataSourceTransactionManager transactionManager;
	

	public void setDaoObject(EmployeeDAO daoObject) {
		this.daoObject = daoObject;
	}

	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(
			DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public void addNewEmployee(Employee emp) {
		TransactionStatus status = null;
		try {
			status = transactionManager.getTransaction(new DefaultTransactionDefinition());
			daoObject.updateEmpCount();
			daoObject.insert(emp);
			transactionManager.commit(status);
		} catch(Exception ex) {
			transactionManager.rollback(status);
			ex.printStackTrace();
		}
	}
	
	public Employee findByEmpId(int empId) {
		return daoObject.findByEmpId(empId);
	}
	
	public void updateEmpByEmpId(int empId) {
		
		daoObject.updateEmpByEmpId(empId);
	}

}
