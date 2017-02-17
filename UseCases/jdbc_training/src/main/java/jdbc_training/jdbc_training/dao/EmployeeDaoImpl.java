package jdbc_training.jdbc_training.dao;

import jdbc_training.jdbc_training.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void saveEmployee(Employee emp) {
		
		String sql = "Insert into employee (id, name) values (?,?)";
		jdbcTemplate.update(sql, emp.getId(), emp.getName());
		
		System.out.println("Employee saved.");
		
	}

	public Employee getEmployee(int id) {
		
//		String sql="select * from Employee";
		
//		jdbcTemplate.query(sql);
		return null;
	}

	public int updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return 0;
	}



}
