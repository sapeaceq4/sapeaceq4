package com.sapient.Repo;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.sapient.Entity.Employee;


public class EmployeeDao {

	
	JdbcTemplate jdbcTemplate;
	
	String insert="insert into employee(Name,Age,Address) values(?,?,?)";
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


    @Transactional
	public int savePerson(Employee emp)
	{
		String[] array={"Aladin","12","asafaf"};
		jdbcTemplate.update(insert,array);
		String[] array1={"Checkingg","1233"};
		jdbcTemplate.update(insert,array1);
		return 1;
	}
}
