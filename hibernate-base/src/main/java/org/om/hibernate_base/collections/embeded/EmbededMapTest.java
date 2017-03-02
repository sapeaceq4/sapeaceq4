package org.om.hibernate_base.collections.embeded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.om.hibernate_base.utils.HibernateUtils;

public class EmbededMapTest 
{
	public static void main(String[] args)
	{
		SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        Item item = new Item("Apple phone");
        item.getImages().put("one", new Image("Image_1.png", "./core/app/images", 52525));
        item.getImages().put("two", new Image("Image_2.png", "./core/app/images", 1234));
        item.getImages().put("three", new Image("Image_3.png", "./core/app/images", 64322));
        
        session.save(item);
        
        transaction.commit();
        session.close();
        factory.close();
	}
}
