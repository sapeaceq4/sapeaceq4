package org.om.hibernate_base.mapping.onetoone.bidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.om.hibernate_base.utils.HibernateUtils;

public class OneToOneBidirectionTest
{
	
	private static Company createComanyWithDummyEmployee()
	{
		Company company = new Company("Sapeint");
		Employee employee = new Employee("Om");
		employee.setCompany(company);
		company.setEmployee(employee);
		return company;
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
