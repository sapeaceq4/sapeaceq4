package org.om.hibernate_base.mapping.onetoone.unidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.om.hibernate_base.utils.HibernateUtils;

public class OneToOneUnidirectionTest
{
	
	private static Company createComanyWithDummyEmployee()
	{
		Company comany = new Company("Sapeint");
		Employee employee = new Employee("Om");
		comany.setEmployee(employee);

		return comany;
	}
	
	public static void main(String[] args) 
	{
		SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(createComanyWithDummyEmployee());
        
        transaction.commit();
        session.close();
        factory.close();
	}
}
