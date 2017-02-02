package com.gm.ace.annotation;


public class AuthorAnnotation {
	
	@Employee(emailId = "avnish.jnu08@gmail.com", name = "avnish")
	public String testEmployee(){
		return "ds";
	}
	
	public static void main(String[] args) {
		
		Class<AuthorAnnotation> c = AuthorAnnotation.class;
		Employee cp = c.getAnnotation(Employee.class);
		System.out.println(cp);
	}
	
}
