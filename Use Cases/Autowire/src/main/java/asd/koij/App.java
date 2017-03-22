package asd.koij;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		System.out.println("Application Container instantiated");
		Book book = (Book) ctx.getBean("book");
		System.out.println(book);
		book.setAuthor("alok");

		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
				"Beans.xml"));
		System.out.println(ctx.getBean("book"));
	}
}
