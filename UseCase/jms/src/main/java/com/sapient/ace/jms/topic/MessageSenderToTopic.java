package com.sapient.ace.jms.topic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;

public class MessageSenderToTopic {
	public static void main(String[] args) {

		TopicConnection connection = null;
		try  
	    {   //Create and start connection  
	        InitialContext context = new InitialContext();  
	        TopicConnectionFactory factory = (TopicConnectionFactory)context.lookup("myConnectionFactory");  
	        connection =factory.createTopicConnection();  
//	        con.start();  // not required because producer know when it will produce the message while consumer don't know when message will produced
	        //2) create queue session  
	        TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);  
	        //3) get the Topic object  
	        Topic topic = (Topic)context.lookup("MyTopic");  
	        //4)create TopicPublisher object          
	        TopicPublisher publisher=session.createPublisher(topic);  
	        //5) create TextMessage object  
	        TextMessage message = session.createTextMessage();  
	          
	        //6) write message  
	        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));  
	        while(true)  
	        {  
	            System.out.println("Enter Msg, end to terminate:");  
	            String s=b.readLine();  
	            if (s.equals("end"))  
	                break;  
	            message.setText(s);  
	            //7) send message  
	            publisher.publish(message);
//	            publisher.publish(message, DeliveryMode.NON_PERSISTENT, 3, 1000); 
	            System.out.println("Message successfully sent.");  
	        }  
	        
	    }catch(Exception e){System.out.println(e);} finally {
	    	//8) connection close  
	        try {
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}  
		} 

	}
}

