package com.sapient.customer.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee(rs.getInt("EMP_ID"), rs.getString("NAME"), rs.getInt("AGE"));
		return emp;
	}

}