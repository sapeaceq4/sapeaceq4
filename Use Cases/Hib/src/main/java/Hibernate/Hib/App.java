package Hibernate.Hib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

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

		try {
			Transaction tx = session.beginTransaction();

			Book b = new Book();
			b.setTitle("akash");
			session.save(b);

			Cover c = new Cover();

			c.setBook(b);
			c.setImageName("alok");
			session.save(c);
			session.flush();
			tx.commit();

			String sql = "select * from book";
			SQLQuery nativeSql = session.createSQLQuery(sql);

			Criteria cri = session.createCriteria(Book.class);
			Criterion criterionName = Restrictions.eq("isbnNumber", 1L);
			cri.add(criterionName);
			// nativeSql.addEntity(Book.class);
			List li = nativeSql.list();
			System.out.println(li);

			System.out.println(cri.list().get(0));
		} finally {
			session.close();
			sessions.close();
		}
	}
}