package com.sapient.ace.spring.jdbc;

import com.sapient.ace.spring.jdbc.dao.EmployeeDao;
import com.sapient.ace.spring.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.sapient.ace.spring.jdbc.transactions.EmployeeTransactionDAO;

/**
 * Created by Ravdeep Singh on 2/16/2017.
 */
public class SpringDaoClient {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-jdbc.xml");
        int i=100;
        EmployeeDao EMPdao=(EmployeeDao)ctx.getBean("edao");

        final Employee om = new Employee(i + 5, "ravdeep5", 100000);
//        int status=EMPdao.saveEmployee(om);
//        System.out.println(status);
//
//        EmployeeTransactionDAO dao = (EmployeeTransactionDAO) ctx.getBean("etdao");
//        dao.updateEmployee(om);

    }
}
