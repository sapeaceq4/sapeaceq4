package Jms.Receiver;

import java.util.Properties;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Jms Receiver!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");

		Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");

		InitialContext context = new InitialContext(props);
		QueueConnectionFactory factory = (QueueConnectionFactory) context
				.lookup("ConnectionFactory");
		Queue queue = (Queue) context.lookup("dynamicQueues/TestMyQueue");
		QueueConnection queueCon = factory.createQueueConnection();
		QueueSession session = queueCon.createQueueSession(false,
				Session.AUTO_ACKNOWLEDGE);
		QueueReceiver Receiver = session.createReceiver(queue);
		TextMessage msg;

		boolean stop = true;

		queueCon.start();
		msg = (TextMessage) Receiver.receive();
		while (null != msg) {
			System.out.println(msg.getText());
			msg = (TextMessage) Receiver.receive();
		}

		queueCon.close();
	}
}
