/**
 * Created by Ravdeep Singh on 2/20/2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class App {

    @Autowired
    private ProductRepository pR;

    @RequestMapping("/ace")
    String home() {
        return "Welcome to 'ACE'..........Have some sp'ACE'";
    }

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        ProductRepository productRepository = context.getBean( "pR",ProductRepository.class);

        productRepository.save(new Product("A", 4, "GREEN", 5.5f));
        productRepository.save(new Product("B", 5, "RED", 10.5f));
        productRepository.save(new Product("C", 6, "BLACK", 100.0f));
    }

}