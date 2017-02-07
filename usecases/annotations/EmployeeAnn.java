package com.sapient.usecases.annotations;

@AuthorAnnotation(emailId = "tulika@sapient.com", authorName = "tulika")
public class EmployeeAnn {

	public static void main(String[] args) {
	Class<EmployeeAnn> e = EmployeeAnn.class;
	AuthorAnnotation aa = e.getAnnotation(AuthorAnnotation.class);
	System.out.println(aa);
	}
}
