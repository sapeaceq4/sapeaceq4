package com.sap.ace; /**
 * Created by Ravdeep Singh on 2/20/2017.
 */

import com.sap.ace.models.Product;
import com.sap.ace.repositories.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        /*ProductRepository productRepository = context.getBean(ProductRepository.class);

        productRepository.save(new Product("A", "GREEN", 5));
        productRepository.save(new Product("B", "RED", 6));
        productRepository.save(new Product("C", "BLACK", 7));*/
    }
}