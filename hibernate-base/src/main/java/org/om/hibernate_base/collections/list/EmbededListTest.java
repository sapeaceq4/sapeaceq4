package org.om.hibernate_base.collections.list;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.om.hibernate_base.utils.HibernateUtils;

public class EmbededListTest 
{
	public static void main(String[] args)
	{
		SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
 
        Company company = new Company("Sapient");
        company.getEmployees().add(new Employee("Om"));
        
        session.save(company);
        
        transaction.commit();
        session.close();
        factory.close();
	}
}
