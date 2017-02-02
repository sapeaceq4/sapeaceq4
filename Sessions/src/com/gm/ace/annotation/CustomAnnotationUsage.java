package com.gm.ace.annotation;


public class CustomAnnotationUsage {
	@CustomAnnotationExample("Welcome to annotation world")
	public String annotFields;
	
	public static void main(String[] args) {
		CustomAnnotationUsage annotationUsage = new CustomAnnotationUsage();
		System.out.println(annotationUsage.annotFields);
	}
	
	
}
