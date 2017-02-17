package jdbc_training.jdbc_training;

import jdbc_training.jdbc_training.dao.EmployeeDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
		
		Employee emp = new Employee(10,"Shubha");
		
		employeeDao.saveEmployee(emp);
    }
}
