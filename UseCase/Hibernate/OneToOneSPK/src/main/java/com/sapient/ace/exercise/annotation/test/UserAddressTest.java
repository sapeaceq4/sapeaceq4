package com.sapient.ace.exercise.annotation.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sapient.ace.exercise.annotation.model.AddressSPK;
import com.sapient.ace.exercise.annotation.model.UserSPK;



public class UserAddressTest {

	public static void main(String[] args) {
		UserSPK user = new UserSPK();
		
		user.setName("user name");
		AddressSPK address = new AddressSPK();
		address.setAddress("User address");
		address.setUser(user);
		user.setShippingAddress(address);
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // if cfg file name is other than "hibernate.cfg.xml" pass that name in configure() method
				.build();
		
		SessionFactory factory = new MetadataSources(registry)
				.addAnnotatedClass(UserSPK.class)
				.addAnnotatedClass(AddressSPK.class)
				.buildMetadata()
				.buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
