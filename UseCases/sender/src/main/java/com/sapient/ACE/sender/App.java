package com.sapient.ACE.sender;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.naming.Context;

/**
 * Hello world!
 *
 */
public class App {
	// public static String brokerURL = "tcp://localhost:8161";
	private ConnectionFactory factory;
	private static Connection connection;
	private static Session session;
	private static MessageProducer producer;

	public static void main(String[] args) throws Exception {
		// setup the connection to ActiveMQ
		// ConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL);

		Context ctx = new javax.naming.InitialContext();

		// Lookup the connection factory:
		QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("queueConnectionFactory");
		connection = factory.createConnection();
//		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("MyQueue");
		producer = session.createProducer(destination);
		Scanner sc = new Scanner(System.in);
		String s="";
		while (!s.equals("stop")) {
			 s=sc.next();
			 if(!s.equals("stop")){
			Message message = session.createTextMessage(s);
			producer.send(message);
			}
		}
		session.close();
		producer.close();
		connection.close();
	}
}
