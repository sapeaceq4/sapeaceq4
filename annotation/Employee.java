package com.sapient.annotation;

import java.io.Serializable;
import java.math.BigDecimal;

public class Employee implements Serializable {

	private static final long serialVersionUID = 7085230097495323616L;
	private BigDecimal empId;
	private String empName;
	private String dept;

	public Employee(BigDecimal i, String empName, String dept) {
		this.empId=i;
		this.empName=empName;
		this.dept=dept;
	}

	public Employee() {
	}

	public Integer getEmpId() {
		return empId.intValue();
	}

	public void setEmpId(BigDecimal bigDecimal) {
		this.empId = bigDecimal;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
