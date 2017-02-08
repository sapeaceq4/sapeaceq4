package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddRecords {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		for (int i = 0; i < 10; i++) {
			UserDetails user = new UserDetails();
			user.setUsername("user "+i);
			session.save(user);
		}

		
		session.getTransaction().commit();
		session.close();
	}
}
