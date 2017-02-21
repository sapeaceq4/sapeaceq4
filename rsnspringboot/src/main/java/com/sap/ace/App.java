package com.sap.ace; /**
 * Created by Ravdeep Singh on 2/20/2017.
 */

import com.sap.ace.models.Product;
import com.sap.ace.repositories.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        productRepository.save(new Product("A", 4, "GREEN", 5.5f));
        productRepository.save(new Product("B", 5, "RED", 10.5f));
        productRepository.save(new Product("C", 6, "BLACK", 100.0f));
    }

}