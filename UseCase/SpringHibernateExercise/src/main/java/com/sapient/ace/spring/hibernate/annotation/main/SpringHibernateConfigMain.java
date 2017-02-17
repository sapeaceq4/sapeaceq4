package com.sapient.ace.spring.hibernate.annotation.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.ace.spring.hibernate.config.dao.EquityDao;
import com.sapient.ace.spring.hibernate.config.model.Equity;

public class SpringHibernateConfigMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		EquityDao equityDAO = context.getBean("equityConfigDAO", EquityDao.class);
		
		Equity equity = new Equity();
		
		equity.setQty(5);
		equity.setSecurityName("securityName 3");
		equity.setSymbol("symbol 3");
		equity.setType("Buy");
		
		equityDAO.saveEntity(equity);
		
		List<Equity> equities = equityDAO.listEquity();
		
		for (Equity equity2 : equities) {
			System.out.println(equity2);
		}
		
	}

}
