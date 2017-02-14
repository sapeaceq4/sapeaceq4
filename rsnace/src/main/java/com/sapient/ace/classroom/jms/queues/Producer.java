package com.sapient.ace.classroom.jms.queues;

import com.sapient.ace.classroom.jms.JMSContext;
import com.sapient.ace.classroom.jms.PriceEntity;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ravdeep Singh on 2/14/2017.
 */
public class Producer {

    private MessageProducer producer;
    private Session session;
    private Context context = null;
    private Connection connection = null;
    private ConnectionFactory factory = null;
    private Destination destination = null;
    private Thread worker;

    public Producer() {
        try {
            context = new JMSContext().init();
            factory = (ConnectionFactory) context.lookup("ConnectionFactory");
            destination = (Destination) context.lookup(JMSContext.destination);
            connection = factory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(destination);
        } catch (JMSException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    public class ProducerWorker implements Runnable {

        @Override
        public void run() {
            try {
                connection.start();
                int i = 0;
                while (i < 1000) {
                    final PriceEntity obj = new PriceEntity("PriceEntity" + i, "id-" + i, 2000.1 + i);
                    ObjectMessage message = session.createObjectMessage(obj);
                    producer.send(message);
                    System.out.println("Sent: " + obj);
                    i++;
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.begin();

        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(60));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.stop();
        System.out.printf("Producer terminated");

    }

    private void stop() {
        worker.interrupt();
        close();
    }

    private void begin() {
        worker = new Thread(new ProducerWorker(), "ProducerWorkerThread");
        worker.start();
    }
}
