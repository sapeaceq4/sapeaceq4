package org.sapient.rsn.persistence.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rsi164 on 2/8/2017.
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory = null;
    private static final Logger logger = Logger.getLogger(HibernateUtils.class.getSimpleName());

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
//            sessionFactory = new Configuration().configure().buildSessionFactory();

             /*Use code below for Hibernate version 4*/
            Configuration configuration = new Configuration();
            configuration = configuration.configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
            builder = builder.applySettings(configuration.getProperties());
            SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

        } catch (Throwable ex) {
//             Log the exception.
            logger.log(Level.INFO, "SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}

