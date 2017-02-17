package com.sapient.ACE.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.ACE.DTOs.Person;

public class PersonDAO {

	final String INSERT = "insert into person "
			+ "(person_name,description) values(?,?)";

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED)
	public void savePerson(Person person) {
		System.out.println("before save");
		jdbcTemplate.update(INSERT, person.getName(), person.getId());
		System.out.println("after save");
	}

}
