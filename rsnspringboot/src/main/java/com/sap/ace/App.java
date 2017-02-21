package com.sap.ace; /**
 * Created by Ravdeep Singh on 2/20/2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        /*ProductRepository productRepository = context.getBean(ProductRepository.class);

        productRepository.save(new Product("A", 4, "GREEN", 5.5f));
        productRepository.save(new Product("B", 5, "RED", 10.5f));
        productRepository.save(new Product("C", 6, "BLACK", 100.0f));

        Iterable<Product> list = productRepository.findAll();

        list.forEach(product -> {
            System.out.println(product);
        });*/
    }
}