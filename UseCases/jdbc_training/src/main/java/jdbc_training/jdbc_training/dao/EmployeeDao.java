package jdbc_training.jdbc_training.dao;

import jdbc_training.jdbc_training.Employee;

public interface EmployeeDao {
	
	void saveEmployee(Employee emp);
	
	Employee getEmployee(int id);
	
	int updateEmployee(Employee emp);
	
	int deleteEmployee(int id);

}
