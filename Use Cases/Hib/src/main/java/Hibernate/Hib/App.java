package Hibernate.Hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Configuration cfg = new Configuration().addAnnotatedClass(Book.class)
				.addAnnotatedClass(Cover.class).configure();

		SessionFactory sessions = cfg.buildSessionFactory();

		Session session = sessions.openSession(); // open a new Session
		Transaction tx = session.beginTransaction();
		//
		// Book b = new Book();
		// b.setTitle("akash");
		// session.save(b);

		Cover c = new Cover();
		// c.setBook(new Book().setIsbnNumber(1));
		Book io = new Book();
		io.setIsbnNumber(1);

		// Book io = session.load(Book.class, 1l);

		c.setBook(io);
		c.setImageName("alok");
		session.save(c);

		session.flush();
		tx.commit();
		session.close();
		sessions.close();
	}
}
