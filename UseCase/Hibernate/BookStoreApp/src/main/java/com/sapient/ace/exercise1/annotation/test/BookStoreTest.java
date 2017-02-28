package com.sapient.ace.exercise1.annotation.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sapient.ace.exercise1.annotation.model.Book;



public class BookStoreTest {

	public static void main(String[] args) {
		Book book = new Book();
		
		book.setIsbn(1l);
		book.setTitle("annotated title");
		book.setPubDate(new Date());
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.annotation.cfg.xml").build();
		
		SessionFactory factory = new MetadataSources(registry).addAnnotatedClass(Book.class).buildMetadata().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(book);
		
		session.getTransaction().commit();
		
		session.close();
		
		System.out.println("Done");
		
		factory.close();
	}

}
