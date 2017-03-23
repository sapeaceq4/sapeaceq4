package org.sapient.rsn.persistence.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sapient.rsn.persistence.hibernate.utils.HibernateUtils;

/**
 * Created by rsi164 on 2/8/2017.
 */
public class HibernateDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();



    }
}
