package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Application {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		
		Session session3 = sf.getCurrentSession();
		Session session4 = sf.getCurrentSession();
		
		if(session1==session2){
			System.out.println("open session matched");
		}else{
			System.out.println("open session mis-matched");
		}
		
		if(session3==session4){
			System.out.println("current session matched");
		}else{
			System.out.println("current session not matched");
		}
	}
}
