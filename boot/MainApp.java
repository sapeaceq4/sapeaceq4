package com.sapient.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp { 
	public static void main(String[] args) throws Exception{ 
	SpringApplication.run(MainApp .class, args);

	
}
}

//******************OLD style
/*public class MainApp { 
	public static void main(String[] args) { 
	ApplicationContext context = new 	ClassPathXmlApplicationContext("com/sapient/boot/spring-context.xml"); 
	HelloWorld obj = (HelloWorld) context.getBean("helloWorld"); 	obj.getMessage(); 
} 
}*/

