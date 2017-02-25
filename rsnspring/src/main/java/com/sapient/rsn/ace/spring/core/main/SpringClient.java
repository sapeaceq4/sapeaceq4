package com.sapient.rsn.ace.spring.core.main;

import com.sapient.rsn.ace.spring.core.bean.*;
import com.sapient.rsn.ace.spring.core.components.Company;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ravdeep Singh on 25-02-2017.
 */
public class SpringClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("-----------------------------------------------");
        Item itemOne = (Item) applicationContext.getBean("item");
        System.out.println(itemOne.getName());
        System.out.println("-----------------------------------------------");

        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student.printDeatils());
        System.out.println("-----------------------------------------------");

        Teacher teacher = (Teacher) applicationContext.getBean("teacher");
        System.out.println(teacher);
        System.out.println("-----------------------------------------------");


        SampleBean sampleBean = (SampleBean) applicationContext.getBean("sample");
        System.out.println(sampleBean.toString());

        System.out.println("----------------Factory Method------------------------");

        Book springbook = (Book) applicationContext.getBean("springbook");
        System.out.println(springbook);
        Book hadoopbook = (Book) applicationContext.getBean("hadoopbook");
        System.out.println(hadoopbook);

        System.out.println("----------------Factory Bean    ------------------------");
        Book hadoopbook2 = (Book) applicationContext.getBean("hadoopbook");
        System.out.println(hadoopbook2);

        System.out.println("----------------For component    ------------------------");
        Client client = (Client) applicationContext.getBean("client");
        client.setName("Ravdeep");
        client.setCountry("India");
        System.out.println(client);


        System.out.println("----------------Component  ------------------------");
        Company company = applicationContext.getBean(Company.class);
        System.out.println(company);
        company.setName("Sapient");
        //getting bean again
        Company company2 = applicationContext.getBean(Company.class);
        System.out.println(company2);


    }
}
