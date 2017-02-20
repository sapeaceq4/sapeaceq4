package com.sapient.ACE.consumer;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;

import org.apache.activemq.ActiveMQConnectionFactory;

public class App implements MessageListener
{
 
    public static String brokerURL = "tcp://localhost:61616";
 
    private ConnectionFactory factory;
    private Connection connection;
    private Session session;
    private MessageConsumer consumer;
 
    public static void main( String[] args )
    {
        App app = new App();
        app.run();
    }
 
    public void run()
    {
        try
        {
        	 Context ctx = new javax.naming.InitialContext();
        	 QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("queueConnectionFactory");
             connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("MyQueue");
            consumer = session.createConsumer(destination);
            consumer.setMessageListener(this);
        }
        catch (Exception e)
        {
            System.out.println("Caught:" + e);
            e.printStackTrace();
        }
    }
 
    public void onMessage(Message message)
    {
    
        try
        {
            if (message instanceof TextMessage)
            {
                TextMessage txtMessage = (TextMessage)message;
                System.out.println("Message received: " + txtMessage.getText());
            }
            else
            {
                System.out.println("Invalid message received.");
            }
        }
        catch (JMSException e)
        {
            System.out.println("Caught:" + e);
            e.printStackTrace();
        }
    }
}