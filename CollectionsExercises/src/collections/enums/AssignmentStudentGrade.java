package collections.enums;

public class AssignmentStudentGrade {
	public static void main(String[] args) {
		Student s1 = new Student(1,"name1",Grade.A);
		Student s2 = new Student(2,"name2",Grade.C);
		
		System.out.println(s1);
		System.out.println(s2);
		
	}
}

enum Grade {
	A("Topper")
	,B("Average")
	,C("Poor")
	,D("Fail");
	
	Grade(String str) {
		this.name = str;
	}
	
	String name;
}

class Student {
	int rollNumber;
	String studentName;
	Grade grade;
	
	Student(int i, String s, Grade g) {
		this.rollNumber = i;
		this.studentName = s;
		this.grade = g;
	}
	
	@Override
	public String toString() {
		return "Student[roll number: "+rollNumber+";student name: "+studentName+";grade: "+grade;
	}
}