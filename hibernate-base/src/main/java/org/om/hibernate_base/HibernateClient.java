package org.om.hibernate_base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.om.hibernate_base.collections.Product;
import org.om.hibernate_base.onetoonemapping.Book;
import org.om.hibernate_base.onetoonemapping.Cover;
import org.om.hibernate_base.utils.HibernateUtils;


/**
 * Hello world!
 *
 */
public class HibernateClient 
{
	private static Product createDummyProduct()
	{
		Product product = new Product("Dell Laptop");
		product.getImages().add("dell-defaut.png");
		product.getImages().add("dell-red.png");
		product.getImages().add("dell-orange.png");
		return product;
	}
	
	private static void saveDummyProduct()
	{
		SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(createDummyProduct());
        transaction.commit();
        session.close();
	}
	
	private static Book createDummyBook(String bookName)
	{
		return new Book(bookName);
	}
	
	private static Cover createDummyCover(String coverName)
	{
		return new Cover(coverName);
	}
	
	private static void saveDummyBook()
	{
		Book book = createDummyBook("Java");
		Cover cover = createDummyCover("DummyCover");
		cover.assignBook(book);
	
		SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
        
	}
	
	public static void main(String[] args) 
	{
		saveDummyProduct();
		saveDummyBook();
	}
}

