package org.om.hibernate_base.mapping.onetomany.bidirection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.om.hibernate_base.utils.HibernateUtils;

/**
 *  Case1:
 	Employee-Entity Class
	@ManyToOne
	private Company company;
	
	Company-Entity Class
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Company_Id")
	private List<Employee> employees = new ArrayList<>();
	
	Assigned two employees to company the save the company. 
	Output:
	Hibernate: insert into H_TBL_COMPANY (name, id) values (?, ?)
	Hibernate: insert into H_TBL_EMPLOYEE (company_id, name, id) values (?, ?, ?)
	Hibernate: insert into H_TBL_EMPLOYEE (company_id, name, id) values (?, ?, ?)
	Hibernate: update H_TBL_EMPLOYEE set Company_Id=? where id=?
	Hibernate: update H_TBL_EMPLOYEE set Company_Id=? where id=?
	
	Case2:
	Employee-Entity Class
	@ManyToOne
	private Company company;
	
	Company-Entity Class
	@OneToMany(cascade=CascadeType.ALL, mappedBy="company")
	private List<Employee> employees = new ArrayList<>();
	
	Output
	Hibernate: insert into H_TBL_COMPANY (name, id) values (?, ?)
	Hibernate: insert into H_TBL_EMPLOYEE (company_id, name, id) values (?, ?, ?)
	Hibernate: insert into H_TBL_EMPLOYEE (company_id, name, id) values (?, ?, ?)

	case3:
	Employee-Entity Class
	@ManyToOne
	private Company company;
	
	Company-Entity Class
	@OneToMany(cascade=CascadeType.ALL, mappedBy="company")
	@JoinColumn(name="Company_Id")
	private List<Employee> employees = new ArrayList<>();
	output:
	Failed
	Exception in thread "main" org.hibernate.AnnotationException: Associations marked as mappedBy 
	must not define database mappings like @JoinTable or @JoinColumn: org.om.hibernate_base.mapping.onetomany.bidirection.Company.employees
 *
 */
public class OneToManyBidirectionTest
{
	
	private static void saveEmployee(Session session)
	{
		Company company = new Company("Siemens");
		Employee employee = new Employee("Ravdeep");
		employee.setCompany(company);
		company.getEmployees().add(employee);
		session.save(employee);
	}
	
	private static Company createComanyWithDummyEmployee()
	{
		Company company = new Company("Sapeint");
		Employee employee1 = new Employee("Om");
		Employee employee2 = new Employee("Ravi");
		employee1.setCompany(company);
		employee2.setCompany(company);
		company.getEmployees().add(employee1);
		company.getEmployees().add(employee2);
		
		return company;
	}
	
	public static void main(String[] args) 
	{
		SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

       // session.save(createComanyWithDummyEmployee());
        saveEmployee(session);
        
        transaction.commit();
        session.close();
        session = null;
        
        
        session = factory.openSession();
        Company company = session.get(Company.class, 2);
        List<Employee> employees = company.getEmployees();
        for (Employee employee : employees)
        {
			System.out.println(employee);
		}
        
        session.close();
        factory.close();
	}
}
