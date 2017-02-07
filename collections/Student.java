package com.sapient.ace.corejava.collections;

public class Student {
	private String name;
	private int rollNo;
	private Grades grade;

	public Student(String name, int rollNo, Grades grade) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public Grades getGrade() {
		return grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public void setGrade(Grades grade) {
		this.grade = grade;
	}

	public void printDetails() {
		System.out.println("Students name is " + getName());
		System.out.println("Students roll no  is " + getRollNo());
		System.out.println("Students grade is " + getGrade());
	}
}
