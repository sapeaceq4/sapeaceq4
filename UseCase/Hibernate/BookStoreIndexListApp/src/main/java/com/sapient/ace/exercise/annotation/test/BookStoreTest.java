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
		
		book.setTitle("title");
		book.setPubDate(new Date());
		book.getAuthors().add("Pankaj");
		book.getAuthors().add("Prem");
		book.getAuthors().add("Kirti Dhar");
		
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		SessionFactory factory = new MetadataSources(registry).addAnnotatedClass(Book.class).buildMetadata().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(book);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
