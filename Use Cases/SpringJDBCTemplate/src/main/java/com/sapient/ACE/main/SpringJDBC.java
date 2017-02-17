package com.sapient.ACE.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sapient.ACE.DAO.PersonDAO;
import com.sapient.ACE.DTOs.Person;

/**
 * Hello world!
 *
 */
public class SpringJDBC {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"ApplicationContext.xml");
		Person app = (Person) context.getBean("person");
		System.out.println(app.toString());
		PersonDAO app1 = (PersonDAO) context.getBean("edao");
		app1.savePerson(app);
	}
}
