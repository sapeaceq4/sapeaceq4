package com.sapient.ace.spring.clients;

import com.sapient.ace.spring.model.Company;
import com.sapient.ace.spring.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ravdeep Singh on 2/15/2017.
 */
public class SpringClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Department obj = (Department) context.getBean("department");

        System.out.println(obj.getName());

        obj.setName("OM");

        Department obj1 = (Department) context.getBean("department");

        System.out.println(obj1.getName());



//        Company company = (Company) context.getBean("company");

//        System.out.printf(company.getDepartment().toString());

//        test(obj);
    }

    private static void test(Object obj) {
//        System.out.printf("val"+ obj.getName());
        System.out.println(obj.getClass().getSimpleName());
    }
}
