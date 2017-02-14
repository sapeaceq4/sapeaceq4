package com.sapient.ace.jms.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

public class MessageSender {
	public static void main(String[] args) {
		QueueConnection connection = null;
		
		try {
			InitialContext  context =  new InitialContext();
			QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("myConnectionFactory");
			connection = factory.createQueueConnection();
			connection.start();
			
			Queue queue = (Queue) context.lookup("MyQueue");
			
			QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueSender sender = session.createSender(queue);  
            
            TextMessage msg = session.createTextMessage();  
			
            BufferedReader b=new BufferedReader(new InputStreamReader(System.in));  
            while(true)  
            {  
                System.out.println("Enter Msg, end to terminate:");  
                String s=b.readLine();  
                if (s.equals("end"))  
                    break;  
                msg.setText(s);  
                //7) send message  
                sender.send(msg);  
                System.out.println("Message successfully sent.");  
            }  
            //8) connection close  
           
		} catch (NamingException | JMSException | IOException e) {
			e.printStackTrace();
		}finally {
			if(connection != null){
				 try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}  
			}
		}
	}
	

}
