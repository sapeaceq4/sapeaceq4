package org.om.aec.jsm;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer
{
	private Connection connection;
	private JmxContext jmxContext;
	public Consumer(JmxContext jmxContext)throws Exception
	{
		this.jmxContext = jmxContext;
		Context context = jmxContext.init();
		ConnectionFactory connectionFactory = (ConnectionFactory)context.lookup("ConnectionFactory"); 
		((ActiveMQConnectionFactory)connectionFactory).setTrustAllPackages(true);
		Destination destination =(Destination)context.lookup(JmxContext.QUEUE_NAME);  
		
		this.connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		MessageConsumer messageConsumer = session.createConsumer(destination);
		messageConsumer.setMessageListener(new MessagePrinter());
	}
	
	public void start()
	{
		try 
		{
			connection.start();
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}
	}
	
	static class MessagePrinter implements MessageListener
	{
		@Override
		public void onMessage(Message message) 
		{
			if (message instanceof ObjectMessage) 
			{
				ObjectMessage objectMessage = (ObjectMessage)message;
				try 
				{
					PriceEntity priceEntity = (PriceEntity)objectMessage.getObject();
					System.out.println("consumer:-"+priceEntity);
				} 
				catch (JMSException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void stop()
	{
		try 
		{
			jmxContext.stop();
			connection.stop();
			connection.close();
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception 
	{  
		new Consumer(new JmxContext()).start();
	}  
}
