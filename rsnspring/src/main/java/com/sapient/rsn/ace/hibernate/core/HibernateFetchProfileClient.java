package com.sapient.rsn.ace.hibernate.core;

import com.sapient.rsn.ace.hibernate.core.models.Country;
import com.sapient.rsn.ace.hibernate.core.models.State;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ravdeep Singh on 01-03-2017.
 */
public class HibernateFetchProfileClient {
    private static final SessionFactory concreteSessionFactory;

    static {
        try {
            concreteSessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession()
            throws HibernateException {
        return concreteSessionFactory.openSession();
    }

    public static void main(String... args) {
        init();
//        fetchLazy();

        fetchProfile();

        concreteSessionFactory.close();
    }

    private static void fetchLazy() {
        Session session;
        session = getSession();
        session.beginTransaction();
        Country con = session.get(Country.class, new Integer(1));
        Set<State> states = con.getStates();
        System.out.println(states.size());
        for (State state : states) {
            System.out.println(state);
        }
        session.clear();
        session.close();

//        System.out.println(con.getStates().size());
    }

    private static void fetchProfile() {
        Session session;

        session = getSession();
        session.beginTransaction();
        //enable fetch profile for EAGER fetching
        session.enableFetchProfile("country_states");
        Country con = session.get(Country.class, new Integer(1));
        System.out.println(con.getStates().size());
        //disable fetch profile
        session.disableFetchProfile("country_states");
        session.clear();
        session.close();
    }

    private static void init() {
        Session session = getSession();
        session.beginTransaction();
        State s1 = new State(1, 1, "UP");
        State s2 = new State(2, 1, "MP");
        Set<State> states = new HashSet<>();
        states.add(s1);
        states.add(s2);
        Country country = new Country(1, "India", states);
        session.persist(country);

//
//        State ss1 = new State(3, 2, "Surrey");
//        State ss2 = new State(4, 2, "MONTREAL");
//        HashSet<State> states2 = new HashSet<>();
//        states2.add(ss1);
//        states2.add(ss2);
//        Country country2 = new Country(2, "CANADA", states2);
//
//        session.persist(country2);
        session.getTransaction().commit();
        session.close();
    }
}
