package org.om.hibernate_base.collections.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.om.hibernate_base.utils.HibernateUtils;

public class MapTest 
{
	public static void main(String[] args)
	{
		SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        Item item = new Item("Apple phone");
        item.getImages().put("one", "Image_1.png");
        item.getImages().put("two", "Image_2.png");
        item.getImages().put("three", "Image_3.png");
        
        
        session.save(item);
        
        transaction.commit();
        session.close();
        factory.close();
	}
}
