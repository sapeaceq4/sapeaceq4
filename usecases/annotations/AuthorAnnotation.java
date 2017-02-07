package com.sapient.usecases.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface AuthorAnnotation {

	String authorName();
	String emailId();
	String EmployeeType() default "Permanent";
}
