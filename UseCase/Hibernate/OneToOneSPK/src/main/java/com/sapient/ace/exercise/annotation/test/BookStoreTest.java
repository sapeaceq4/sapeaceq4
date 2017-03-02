package com.sapient.ace.exercise.annotation.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sapient.ace.exercise.annotation.model.Book;
import com.sapient.ace.exercise.annotation.model.Cover;



public class BookStoreTest {

	public static void main(String[] args) {
		Book book = new Book();
		
		book.setIsbn(1l);
		book.setTitle("annotated title");
		book.setPubDate(new Date());
		
		Cover cover = new Cover();
		cover.setName("cover 1");
		cover.setBook(book);
		book.setCover(cover);
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // if cfg file name is other than "hibernate.cfg.xml" pass that name in configure() method
				.build();
		
		SessionFactory factory = new MetadataSources(registry)
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Cover.class)
				.buildMetadata()
				.buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(book);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Done");
		
		factory.close();
	}

}
