package com.sapient.ace.spring.hibernate.annotation.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.ace.spring.hibernate.annotation.dao.EquityDao;
import com.sapient.ace.spring.hibernate.annotation.model.Equity;



public class SpringHibernateAnnoationMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation.xml");
		
		EquityDao equityDAO = context.getBean("equityAnnotationDAO", EquityDao.class);
		
		Equity equity = new Equity();
		
		equity.setQty(4);
		equity.setSecurityName("securityName 3");
		equity.setSymbol("symbol 3");
		equity.setType("sell");
		
		equityDAO.saveEntity(equity);
		
		List<Equity> equities = equityDAO.listEquity();
		
		for (Equity equity2 : equities) {
			System.out.println(equity2);
		}
		
	}

}
