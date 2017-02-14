package com.sapient.ace.classroom.jms.queues;

import com.sapient.ace.classroom.jms.JMSContext;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh on 2/14/2017.
 */
public class Consumer {

    private MessageConsumer consumer;
    private Session session;
    private Context context = null;
    private Connection connection = null;
    private ConnectionFactory factory = null;
    private Destination destination = null;
    private Thread worker;

    public Consumer() {
        try {
            context = new JMSContext().init();
            factory = (ConnectionFactory) context.lookup("ConnectionFactory");
            ((ActiveMQConnectionFactory) factory).setTrustAllPackages(true);
            destination = (Destination) context.lookup(JMSContext.destination);
            connection = factory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            consumer = session.createConsumer(destination);
            consumer.setMessageListener(new ConsumerMessageListener(" RSN:Consumer "));
        } catch (JMSException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    public void start() {
        try {
            connection.start();
            try {
                Thread.sleep(TimeUnit.MINUTES.toMillis(60));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            session.close();
        } catch (JMSException ex) {
            ex.printStackTrace();
        }

    }

    public void stop() {

        if (connection != null) {
            try {
                connection.close();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        consumer.start();
        try {
            Thread.sleep(TimeUnit.MINUTES.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.stop();

    }

}
