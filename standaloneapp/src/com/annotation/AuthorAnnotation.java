package com.annotation;

@Employee(autherName="test",emailId="test@abc.com",employeeType="Perm")
public class AuthorAnnotation {

	public static void main(String[] args) {
		
		Class<AuthorAnnotation> c = AuthorAnnotation.class;
	}
}
