import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ravdeep Singh on 2/20/2017.
 */

@RestController
public class ProductController
{
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/products")
    public List<Product> getProducts()
    {
        return (List<Product>) productRepository.findAll();
    }

    @RequestMapping("/products/{id}")
    public Product getProductById(@PathVariable long id)
    {
        return productRepository.findOne(id);
    }

    @RequestMapping(value = "/products/", method = RequestMethod.POST,headers="Accept=application/json")
    public Product createProduct(@RequestBody Product product)
    {
        return productRepository.save(product);
    }

}

