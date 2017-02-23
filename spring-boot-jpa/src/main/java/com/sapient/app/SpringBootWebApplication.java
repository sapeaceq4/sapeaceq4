package com.sapient.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.sapient.entity.Product;
import com.sapient.repo.ProductRepository;


@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository pr) {
		return (args) -> {
			//save products
			pr.save(new Product("product1"));
			pr.save(new Product("product2"));
			pr.save(new Product("product3"));
			pr.save(new Product("product4"));
		};
		
	}
}