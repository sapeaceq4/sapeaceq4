package org.om.hibernate_base.mapping.manytomany.unidirection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.om.hibernate_base.utils.HibernateUtils;

/**
 *
 */
public class OneToManyBidirectionTest
{
	
	private static void saveEmployee(Session session)
	{
		Company company = new Company("Siemens");
		Employee employee = new Employee("Ravdeep");
		employee.getCompanies().add(company);
		company.getEmployees().add(employee);
		session.save(employee);
	}
	
	private static Company createComanyWithDummyEmployee()
	{
		Company company = new Company("Sapeint");
		Employee employee1 = new Employee("Om");
		Employee employee2 = new Employee("Ravi");
		employee1.getCompanies().add(company);
		employee2.getCompanies().add(company);
		company.getEmployees().add(employee1);
		company.getEmployees().add(employee2);
		
		return company;
	}
	
	public static void main(String[] args) 
	{
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(createComanyWithDummyEmployee());
		//saveEmployee(session);

		transaction.commit();
		session.close();
		session = null;


		session = factory.openSession();
		
		//retriveCompanyDetails(session);

		session.close();
		factory.close();
	}

	private static void retriveCompanyDetails(Session session) {
		Company company = session.get(Company.class, 1);
		List<Employee> employees = company.getEmployees();
		for (Employee employee : employees)
		{
			System.out.println(employee);
		}
	}
}
