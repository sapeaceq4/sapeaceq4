package com.sapient.ace.classroom.jms.queues;

import com.sapient.ace.classroom.jms.PriceEntity;

import javax.jms.*;

/**
 * Created by Ravdeep Singh on 2/14/2017.
 */
public class ConsumerMessageListener implements MessageListener {
    private String consumerName;

    public ConsumerMessageListener(String consumerName) {
        this.consumerName = consumerName;
    }

    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println(consumerName + " received " + textMessage.getText());
            } else if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                PriceEntity obj= (PriceEntity) objectMessage.getObject();
                System.out.println(consumerName + " received " + obj.toString());
            }
        } catch (JMSException e) {
            System.out.printf("Exception occurred " + e);
        }
    }
}
