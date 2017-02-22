package com.sapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(Application.class, args);
		TestBean bean1 =  (TestBean) context.getBean("Bean1");
		bean1.setId(1);
		bean1.setName("Dinesh");
		System.out.println(bean1.toString());
	}
}
