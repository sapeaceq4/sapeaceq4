package com.sapient.ace.spring.hibernate.config.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sapient.ace.spring.hibernate.config.model.Equity;

public class EquityDaoImpl implements EquityDao{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void saveEntity(Equity equity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(equity);
		tx.commit();
		session.close();
	}

	@Override
	public List<Equity> listEquity() {
		Session session = this.sessionFactory.openSession();
		List<Equity> equityList = session.createQuery("from Equity").list();
		session.close();
		return equityList;
	}

}
