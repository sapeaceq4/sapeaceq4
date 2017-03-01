package com.sapient.rsn.ace.hibernate.core;

import com.sapient.rsn.ace.hibernate.core.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Ravdeep Singh on 3/1/2017.
 */
public class HibernateClient {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
//        saveItems(session);
//        saveBooks(session);

        saveCompany(session);
        checkProxy(session);

        session.flush();
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

    private static void checkProxy(Session session) {
        System.out.println("Checking proxy");
        Company company = session.get(Company.class,1L);
        company.getId();
        company.getName();
        Employee e3 = new Employee("Surender");
        company.setEmployee(e3);

        session.save(e3);
    }

    private static void saveCompany(Session session) {
        Company company = new Company();
        Employee employee1 = new Employee("OM");
        Employee employee2 = new Employee("DEEP");

        company.setName("SAPIENT");
        company.getEmployees().add(employee1);
        company.getEmployees().add(employee2);

        session.save(company);

    }

    private static void saveItems(Session session) {
        ItemSet items = new ItemSet();

        items.setName("LaptopAsus");
        session.save(items);
        items.getImages().add("CLosed");
        items.getImages().add("open");
        items.getImages().add("config");

        session.save(items);
    }

    private static void saveBooks(Session session) {
        Book book = new Book();
        book.setName("TOJ");

        Cover cover = new Cover();
        cover.setName("black");

        book.setCover(cover);
        cover.setBook(book);

        session.save(book);
        session.flush();
    }
}
