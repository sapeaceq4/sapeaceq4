package org.om.hibernate_base.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils 
{
	private static SessionFactory factory;
	public static SessionFactory getSessionFactory()
	{
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        if(factory == null)
        	factory = cfg.buildSessionFactory();
        return factory;
	}
}
