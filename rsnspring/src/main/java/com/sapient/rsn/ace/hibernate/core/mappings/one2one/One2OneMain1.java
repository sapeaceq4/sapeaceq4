package com.sapient.rsn.ace.hibernate.core.mappings.one2one;

import com.sapient.rsn.ace.hibernate.core.models.Address;
import com.sapient.rsn.ace.hibernate.core.models.Student;
import com.sapient.rsn.ace.hibernate.core.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Ravdeep Singh on 02-03-2017.
 */
public class One2OneMain1 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getConcreteSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Address address1 = new Address("OMR Road", "Chennai", "TN", "600097");
            Address address2 = new Address("Ring Road", "Banglore", "Karnataka", "560000");
            Student student1 = new Student("Eswar", address1);
            Student student2 = new Student("Joe", address2);
            session.save(student1);
            session.save(student2);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.closeConcreteSessionFactory();
        }

    }
}
