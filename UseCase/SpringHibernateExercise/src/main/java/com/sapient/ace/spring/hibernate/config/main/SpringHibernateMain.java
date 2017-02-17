package com.sapient.ace.spring.hibernate.config.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.ace.spring.hibernate.config.dao.EquityDao;
import com.sapient.ace.spring.hibernate.config.model.Equity;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		EquityDao equityDAO = context.getBean("equityConfigDAO", EquityDao.class);
		
		Equity equity = new Equity();
		
		equity.setQty(1);
		equity.setSecurityName("securityName 2");
		equity.setSymbol("symbol 2");
		equity.setType("sell");
		
		equityDAO.saveEntity(equity);
		
		List<Equity> equities = equityDAO.listEquity();
		
		for (Equity equity2 : equities) {
			System.out.println(equity2);
		}
		
	}

}
