package com.sapient.ace.jms.topic;

import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;

public class MessageReceiverFromTopic {

	public static void main(String[] args) {
		try {
			// 1) Create and start connection
			InitialContext context = new InitialContext();
			TopicConnectionFactory factory = (TopicConnectionFactory) context.lookup("myConnectionFactory");
			TopicConnection connection = factory.createTopicConnection();
			connection.start();
			// 2) create topic session
			TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			// 3) get the Topic object
			Topic topic = (Topic) context.lookup("MyTopic");
			// 4)create TopicSubscriber
			TopicSubscriber receiver = session.createSubscriber(topic);

			// 5) create listener object
			MyTopicListener listener = new MyTopicListener();

			// 6) register the listener object with subscriber
			receiver.setMessageListener(listener);

			System.out.println("Subscriber1 is ready, waiting for messages...");
			System.out.println("press Ctrl+c to shutdown...");
			while (true) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
