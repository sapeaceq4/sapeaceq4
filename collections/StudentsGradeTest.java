package com.sapient.ace.corejava.collections;

public class StudentsGradeTest {

	public static void main(String[] args) {
		Student mohit = new Student("Mohit", 1, Grades.B);
		Student tulika = new Student("Tulika", 2, Grades.A);
		mohit.printDetails();
		System.out.println();
		tulika.printDetails();
	}

}
