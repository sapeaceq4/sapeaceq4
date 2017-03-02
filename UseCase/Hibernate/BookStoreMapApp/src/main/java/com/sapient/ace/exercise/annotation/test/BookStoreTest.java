package com.sapient.ace.exercise.annotation.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sapient.ace.exercise.annotation.model.Book;



public class BookStoreTest {

	public static void main(String[] args) {
		Book book = new Book();
		
		book.setTitle("Title");
		book.setPubDate(new Date());
		book.getImages().put("One", "first image");
		book.getImages().put("Two", "second image");
		book.getImages().put("Three", "Third image");
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
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
