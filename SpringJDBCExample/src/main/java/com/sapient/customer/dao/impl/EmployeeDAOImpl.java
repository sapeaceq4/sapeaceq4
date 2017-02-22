package com.sapient.customer.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sapient.customer.dao.EmployeeDAO;
import com.sapient.customer.model.Employee;
import com.sapient.customer.model.EmployeeRowMapper;

public class EmployeeDAOImpl implements EmployeeDAO
{
	private JdbcTemplate JdbcTemplate;
	
	public void setDataSource(JdbcTemplate dataSource) {
		this.JdbcTemplate = dataSource;
	}
	
	@Override
	public void insert(Employee emp){
		
		String sql = "INSERT INTO Employee " +
				"(EMP_ID, NAME, AGE) VALUES (?, ?, ?)";
		JdbcTemplate.update(sql, new Object[]{emp.getId(), emp.getName(), emp.getAge()});
	}

	@Override
	public Employee findByEmpId(int empId) {
		String sql = "select * from Employee where EMP_ID = " + empId;
		return (Employee) JdbcTemplate.query(sql, new EmployeeRowMapper() ).get(0);
	}
	
	public int getNoOfEmployees() {
		String sql = "select count(*) from Employee";
		return JdbcTemplate.queryForInt(sql);
	}
	
	@Override
	public void updateEmpByEmpId(int empId) {
		String sql = "update Employee set AGE = 30 where EMP_ID = " + empId;
		JdbcTemplate.update(sql);
	}
	
	@Override
	public void updateEmpCount() {
		String sql = "update EmployeeCount set EMPCOUNT = " + (getNoOfEmployees() + 1);
		JdbcTemplate.update(sql);
	}
	
}




