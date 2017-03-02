package com.sapient.ace.exercise.annotation.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sapient.ace.exercise.annotation.model.HibernateUtils;
import com.sapient.ace.exercise.annotation.model.Image;
import com.sapient.ace.exercise.annotation.model.Item;

public class EmbededMapTest {
	
	public static void main(String[] args)
	{
		SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        
        Item item = new Item("Apple phone");
        item.getImages().put("one", new Image("Image_1.png", "./core/app/images", 52525));
        item.getImages().put("two", new Image("Image_2.png", "./core/app/images", 1234));
        item.getImages().put("three", new Image("Image_3.png", "./core/app/images", 64322));
        
        session.save(item);
        
        session.getTransaction().commit();
        session.close();
        factory.close();
	}

}
