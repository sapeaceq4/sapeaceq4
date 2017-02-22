package com.example;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("employeeDao")
public class EmployeeDao implements IEmployeeDao{

	final String sql = "INSERT INTO employee ( name, address) VALUES (?, ?)";
	
	JdbcTemplate temp = null;
	
	public JdbcTemplate getTemp() {
		return temp;
	}

	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}

	@Override
	@Transactional
	public void insert(Employee employee) {
		temp.update(sql,"Dinesh5","Delhi1");
		Object a = null;
		a.toString();
		temp.update(sql,employee.getName(),employee.getAddress());
		System.out.println("Saved in DB--------------->");
	}

	@Override
	public Employee findByCustomerId(int custId) {
		return null;
	}
	

}
