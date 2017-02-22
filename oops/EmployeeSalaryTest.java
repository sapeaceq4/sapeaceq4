package com.sapient.ace.corejava.oops;

import java.util.Scanner;

import com.sapient.ace.corejava.oops.Contractor;
import com.sapient.ace.corejava.oops.Employee;
import com.sapient.ace.corejava.oops.RegularEmployee;

public class EmployeeSalaryTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee();
		for (;;) {
			System.out.println("Please Enter type of Employee:- 1 for Contractor or 2 for Regular or 0 to exit ");
			int empType = scanner.nextInt();
			switch (empType) {
			case 0:
				System.exit(0);
				scanner.close();
				break;
			case 1:
				employee = new Contractor();
				break;
			case 2:
				employee = new RegularEmployee();
				break;
			}
			System.out.println("Please enter employee name");
			employee.setName(scanner.next());
			System.out.println("Please enter employee salary ");
			employee.setSalary(scanner.nextDouble());

			System.out.println("Incremented salary is " + employee.calculateIncrementedSalary());
		}
	}
}
