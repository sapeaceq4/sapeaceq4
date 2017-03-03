package com.sapient.rsn.ace.hibernate.core.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Ravdeep Singh on 02-03-2017.
 */
public class HibernateUtil {
    private static final SessionFactory concreteSessionFactory;

    static {
        try {
            concreteSessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getConcreteSessionFactory()
            throws HibernateException {
        return concreteSessionFactory;
    }
    public static void closeConcreteSessionFactory()
            throws HibernateException {
         concreteSessionFactory.close();
    }
}
