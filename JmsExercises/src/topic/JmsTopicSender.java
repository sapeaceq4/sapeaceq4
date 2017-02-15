package topic;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsTopicSender {
	public static void main(String[] args) throws NamingException,JMSException {
		InitialContext context = new InitialContext();
		QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) context.lookup("queueConnectionFactory");
		Queue queue = (Queue) context.lookup("dynamicQueues/testQ");
		
		QueueConnection conn = queueConnectionFactory.createQueueConnection();
		//TODO topic
		QueueSession session = conn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
		QueueSender sender = session.createSender(queue);
		
		TextMessage textMessage = session.createTextMessage();
		//Scanner scanner = new Scanner(System.in);
		while(true){
			//textMessage.setText(scanner.nextLine());
			textMessage.setText(Double.toHexString(Math.random()));
			sender.send(textMessage);
			System.out.println("sent message: "+ textMessage.toString());
		}
		
	}
}
