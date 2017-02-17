package com.sapient.annotation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	
	private static final String sql = "insert into  employee values (?,?,?)";
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void saveEmployee(Employee employee) {
		jdbcTemplate.update(sql,employee.getEmpId(),employee.getEmpName(),employee.getDept());
		
		System.out.println("DB update");
		jdbcTemplate.update(sql,employee.getEmpId(),employee.getEmpName(),employee.getDept().concat("xxxxxxxxxx"));
	}

	public List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		List<Map<String, Object>> empList=jdbcTemplate.queryForList("select * from employee");
		for (Map<String, Object> map : empList) {
			Employee employee = new Employee();
			employee.setEmpId((BigDecimal) map.get("empId"));
			employee.setEmpName((String) map.get("empName"));
			employee.setDept((String) map.get("dept"));
			list.add(employee);
		}
		return list;
	}

}
