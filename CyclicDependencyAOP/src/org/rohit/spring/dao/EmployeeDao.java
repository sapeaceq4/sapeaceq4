package org.rohit.spring.dao;

import org.rohit.spring.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {

	JdbcTemplate template = null;
	
	final String INSERT = "insert into Employee (name, id) values (?,?)" ;
	
	public void saveEmp(Employee emp)
	{
		template.update(INSERT, new Object[]{emp.getName(),emp.getId()});
	//	int i = 1/0;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
}
