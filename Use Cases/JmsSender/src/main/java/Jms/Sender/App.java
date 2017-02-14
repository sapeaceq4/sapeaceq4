package Jms.Sender;

import java.util.Properties;
import java.util.Scanner;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Jms Sender!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");

		Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		props.setProperty("queue.MyQueue", "TestMyQueue");

		InitialContext context = new InitialContext(props);
		QueueConnectionFactory factory = (QueueConnectionFactory) context
				.lookup("ConnectionFactory");
		Queue queue = (Queue) context.lookup("dynamicQueues/TestMyQueue");
		QueueConnection queueCon = factory.createQueueConnection();
		QueueSession session = queueCon.createQueueSession(false,
				Session.AUTO_ACKNOWLEDGE);
		QueueSender sender = session.createSender(queue);
		TextMessage msg = session.createTextMessage();

		Scanner sc = new Scanner(System.in);
		boolean stop = true;
		String nextMsg;

		while (stop) {
			nextMsg = sc.nextLine();
			if ("stop".equals(nextMsg)) {
				stop = false;
			}
			msg.setText(nextMsg);
			sender.send(msg);
		}

		queueCon.close();
	}
}
