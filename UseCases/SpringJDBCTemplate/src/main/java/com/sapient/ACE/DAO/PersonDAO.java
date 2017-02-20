package com.sapient.ACE.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.ACE.DTOs.Person;

public class PersonDAO {

	final String INSERT= "insert into person "+"(person_name,description) values(?,?)";
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void savePerson(Person person) {

		jdbcTemplate.update(INSERT,person.getName(),person.getId());
	}
	
}
