package org.om.aec.jsm;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;

import org.om.aec.utils.CommonTools;

public class Producer implements Runnable
{
	private final Connection connection;
	private final MessageProducer messageProducer;
	private final Session session;
	private final Thread thread;
	private volatile boolean isStopTiger;
	private JmxContext jmxContext;
	
	public Producer(JmxContext jmxContext)throws Exception
	{ 
		this.jmxContext = jmxContext;
		Context context = jmxContext.init();
		ConnectionFactory connectionFactory = (ConnectionFactory)context.lookup("ConnectionFactory"); 
		this.connection = connectionFactory.createConnection();
		this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination =(Destination)context.lookup(JmxContext.QUEUE_NAME);  
		this.messageProducer = session.createProducer(destination);
		this.thread = new Thread(this, "ProducerThread");
	}

	public void stop() throws JMSException
	{
		jmxContext.stop();
		isStopTiger = false;
		this.thread.interrupt();
		connection.close();
	}
	
	
	public void start()
	{
		this.thread.start();
	}

	@Override
	public void run() 
	{
		try 
		{
			double price = 100;
			while(!isStopTiger)
			{
				ObjectMessage objectMessage = session.createObjectMessage(new PriceEntity("Om", "1", price++));
				messageProducer.send(objectMessage);
				CommonTools.asleep(1000);
			}
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception 
	{  
		new Producer(new JmxContext()).start();
	}
}
