package org.om.hibernate_base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.om.hibernate_base.collections.bag.Item;
import org.om.hibernate_base.collections.list.Company;
import org.om.hibernate_base.collections.list.Employee;
import org.om.hibernate_base.collections.set.Product;
import org.om.hibernate_base.onetoonemapping.Book;
import org.om.hibernate_base.onetoonemapping.Cover;
import org.om.hibernate_base.utils.HibernateUtils;


/**
 * Hello world!
 *
 */
public class HibernateClient 
{
	private static void saveCompany(Session session)
	{
		Company company = new Company("Sapient");
		company.getEmployees().add("Om");
		company.getEmployees().add("Depp");
		session.save(company);
		
	}
	
	private static Item createDummyItem()
	{
		Item item = new Item("Dell Laptop");
		item.getImages().add("dell-defaut.png");
		item.getImages().add("dell-red.png");
		item.getImages().add("dell-orange.png");
		return item;
	}
	
	private static void saveDummyItem(Session session)
	{
        session.save(createDummyItem());
	}
	
	private static Product createDummyProduct()
	{
		Product product = new Product("Dell Laptop");
		product.getImages().add("dell-defaut.png");
		product.getImages().add("dell-red.png");
		product.getImages().add("dell-orange.png");
		return product;
	}
	
	private static void saveDummyProduct(Session session)
	{
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
	
	private static void saveDummyBook(Session session)
	{
		Book book = createDummyBook("Java");
		Cover cover = createDummyCover("DummyCover");
		cover.assignBook(book);
        session.save(book);
	}
	
	public static void main(String[] args) 
	{
		SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
//		saveDummyItem(session);
//		saveDummyProduct(session);
//		saveDummyBook(session);
        saveCompany(session);
        transaction.commit();
        session.close();
        factory.close();
	}
}

