package com.sapient.ace.spring.jdbc.dao;

import com.sapient.ace.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Ravdeep Singh on 2/16/2017.
 */

public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    public int saveEmployee(Employee e) {
        String query = "insert into employee values( '" + e.getId() + "', '" + e.getName() + "', '" + e.getSalary() + "')";
        System.out.println(e.toString()+" " +query);
        return jdbcTemplate.update(query);
    }

    public int updateEmployee(Employee e) {
        String query = "update employee set name = '" + e.getName() + "', salary = '" + e.getSalary() + "' where id = '" + e.getId() + "' ";
        return jdbcTemplate.update(query);
    }
    public int getEmployee(Employee e) {
        /*String query = "update employee set name = '" + e.getName() + "', salary = '" + e.getSalary() + "' where id = '" + e.getId() + "' ";
        return jdbcTemplate.update(query);*/
        throw new RuntimeException("LOL");
    }

    public int deleteEmployee(Employee e) {
        String query = "delete from employee where id='" + e.getId() + "' ";
        return jdbcTemplate.update(query);
    }
}
