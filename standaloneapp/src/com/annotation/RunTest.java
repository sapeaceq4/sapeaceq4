package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RunTest {

	public static void main(String[] args) {

		int passed = 0, failed = 0, count = 0, ignore = 0;
		
		Class<TestExample> obj = TestExample.class;
		
		Annotation[] annotations = obj.getAnnotations();
		
		for (int i = 0; i < annotations.length; i++) {
			System.out.println(annotations[i]);
		}
		
		if(obj.isAnnotationPresent(TesterInfo.class)){
			System.out.println("annotation found for TesterInfo Class");
			
			TesterInfo testerInfo =  (TesterInfo)obj.getAnnotation(TesterInfo.class);
			System.out.println(testerInfo.createdBy()+" "+testerInfo.priority());
			String[] tagsvalue = testerInfo.tags();
			
			for(int j=0;j<tagsvalue.length;j++){
				System.out.println("tags are "+tagsvalue[j]);
			}
			
			Method[] methods =  obj.getDeclaredMethods();
			for (Method method : methods) {
				if(method.isAnnotationPresent(Test.class)){
					Test test = (Test)method.getAnnotation(Test.class);
					Boolean b = test.enable();
					System.out.println(b);
				}
			}
		}
	}
	
}