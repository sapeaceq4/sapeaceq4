package queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsQueueReceiver {
	public static void main(String[] args) throws NamingException,JMSException {
		InitialContext initialContext = new InitialContext();
		QueueConnectionFactory  factory = (QueueConnectionFactory) initialContext.lookup("queueConnectionFactory");
		Queue queue = (Queue) initialContext.lookup("dynamicQueues/testQ");
		
		QueueConnection conn = factory.createQueueConnection();
		QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		QueueReceiver receiver = session.createReceiver(queue);
		conn.start();
		
		while(true){
			Message message = receiver.receive();
			TextMessage textMessage = (TextMessage) message;
			System.out.println("Message received: "+textMessage.toString());
		}
	}
}
