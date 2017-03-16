package com.sapient.rsn.ace.hibernate.core;

import com.sapient.rsn.ace.hibernate.core.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Ravdeep Singh on 3/16/2017.
 */
public class HibernateClient2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        try {
             sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

            Session session1 = sessionFactory.openSession();
            Employee e = null;
            e = session1.get(Employee.class, 2L);

            e.setName("OM SHOM");


            System.out.println(session1.isDirty());

//            session1.update(e0);
            session1.close();

//        System.out.println(e.getName());

            e.setName("OMI");

            Session session2 = sessionFactory.openSession();
            Employee e2 = null;
            e2 = session2.get(Employee.class, 2L);

            session2.merge(e);


            session2.close();
        }finally {
            sessionFactory.close();
        }

    }
}
