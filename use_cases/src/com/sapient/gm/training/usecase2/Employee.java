package com.sapient.gm.training.usecase2;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 4696373550027687317L;

	private String name;
	private Integer age;
	private Long salary;
	private Boolean isRead;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	@Override
	public String toString() {
		return "[name] +"+name+" [age] "+age+" [salary] "+salary+" [isRead] "+isRead;
	}
}