package springboot.org.om.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

import springboot.org.om.product.entity.Product;
import springboot.org.om.product.repositories.ProductRepository;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@RestController
public class AppClient 
{
	private static void addDummyProducts(ProductRepository productRepository)
	{
		productRepository.save(new Product("A", 4, "GREEN", 5.5f));
		productRepository.save(new Product("B", 8, "RED", 6.5f));
		productRepository.save(new Product("C", 12, "YELLOW", 9.5f));
	}
	
	public static void main(String[] args) 
	{
		ConfigurableApplicationContext applicationContext = SpringApplication.run(AppClient.class, args);
		addDummyProducts(applicationContext.getBean(ProductRepository.class));
	}
}
