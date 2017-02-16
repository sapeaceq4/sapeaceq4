package org.om.aec.spring.jdbc.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.om.aec.spring.jdbc.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class EmployeeJdbcTemplate implements EmployeeDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public void createEmployee(Employee employee)
	{
		final String CREATE_QUERY = "INSERT INTO Employee VALUES(?,?,?)";
		
		jdbcTemplate.update(CREATE_QUERY, employee.getId(), 
				employee.getFirstName(), employee.getLastName());
	}
	
	public void updateEmployee(Employee employee)
	{
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);

		try
		{
			final String UPDATE_QUERY = "UPDATE Employee SET firstName=?, lastName=? where id=?";
			jdbcTemplate.update(UPDATE_QUERY,
					employee.getFirstName(), employee.getLastName(), employee.getId());
			transactionManager.commit(status);
		}
		catch(DataAccessException accessException)
		{
			accessException.printStackTrace();
			transactionManager.rollback(status);
		}

	}

	@Override
	public Employee getEmployeById(int employeeId) 
	{
		final String READ_QUERY = "SELECT * FROM Employee WHERE ID = ?";
		return jdbcTemplate.queryForObject(READ_QUERY, new Object[]{employeeId}, new RowMapper<Employee>()
		{
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
				return new Employee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"));
			}
			
		});
	}

	@Override
	public void deleteEmployee(int employeeId)
	{
		final String DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE id=?";
		jdbcTemplate.update(DELETE_QUERY, employeeId);
	}

	@Override
	public List<Employee> getAllEmployees()
	{
		final String READ_ALL_QUERY = "SELECT * FROM Employee";
		List<Employee> employees = new ArrayList<Employee>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(READ_ALL_QUERY);
		for (Map<String, Object> row : rows) 
		{
			BigDecimal bigDecimal = (BigDecimal)row.get("id");
			Employee employee = new Employee(bigDecimal.intValue(),
					(String)row.get("firstName"), (String)row.get("lastName"));
			employees.add(employee);
		}

		return employees;
	}
}
