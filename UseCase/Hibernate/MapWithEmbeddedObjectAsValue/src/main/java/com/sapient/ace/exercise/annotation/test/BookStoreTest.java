package com.sapient.ace.exercise.annotation.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sapient.ace.exercise.annotation.model.Author;
import com.sapient.ace.exercise.annotation.model.Book;



public class BookStoreTest {

	public static void main(String[] args) {
		Book book = new Book();
		
		book.setTitle("Title");
		book.setPubDate(new Date());
		book.getAuthors().put("First", new Author("First Author", "First Author description"));
		book.getAuthors().put("Second", new Author("Second Author", "Second Author description"));
		book.getAuthors().put("Third", new Author("Third Author", "Third Author description"));
		
		
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
