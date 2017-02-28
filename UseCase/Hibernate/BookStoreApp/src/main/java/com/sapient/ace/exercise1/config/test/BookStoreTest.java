package com.sapient.ace.exercise1.config.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sapient.ace.exercise1.config.model.Book;

public class BookStoreTest {

	public static void main(String[] args) {
		Book book = new Book();
		
		book.setIsbn(2l);
		book.setTitle("title");
		book.setPubDate(new Date());
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(book);
		
		session.getTransaction().commit();
		
		session.close();
		
		System.out.println("Done");
		
		factory.close();
	}

}
