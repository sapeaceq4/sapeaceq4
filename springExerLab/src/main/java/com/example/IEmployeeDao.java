package com.example;

public interface IEmployeeDao {

		public void insert(Employee employee);
		public Employee findByCustomerId(int custId);
}
