import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SenderReceiver {

	public static void sendMessage() throws NamingException {
		Context cxt = new InitialContext();
		QueueConnectionFactory factory = (QueueConnectionFactory) cxt
				.lookup("QueueConnectionFactory");
		Queue queue = (Queue) cxt.lookup("MyQueue");
		QueueConnection connetion;
		try {
			connetion = (QueueConnection) factory.createConnection();

			QueueSession session = connetion.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			QueueSender sender = session.createSender(queue);
			TextMessage message = session.createTextMessage("hello World");
			sender.send(message);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void receiveMessage() throws NamingException
	{

		Context cxt = new InitialContext();
		QueueConnectionFactory factory = (QueueConnectionFactory) cxt
				.lookup("QueueConnectionFactory");
		Queue queue = (Queue) cxt.lookup("MyQueue");
		QueueConnection connetion;
		try {
			connetion = (QueueConnection) factory.createConnection();

			QueueSession session = connetion.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			 QueueReceiver receiver= session.createReceiver(queue);
			 connetion.start();
			 while(true)
			 {
				 System.out.println(((TextMessage)receiver.receive()).getText());
			 }
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

}
