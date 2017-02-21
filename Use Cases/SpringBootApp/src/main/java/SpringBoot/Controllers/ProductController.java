package SpringBoot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import SpringBoot.Domain.Product;
import SpringBoot.Domain.Rating;
import SpringBoot.Service.ProductService;
import SpringBoot.Service.RatingService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private RatingService ratingService;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Product> list() {
		return productService.listAllProducts();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveProduct(@RequestBody Product product,
			@RequestParam String user) {
		ratingService.saveRating(new Rating(product.getRating(), product
				.getId(), user));
		productService.saveProduct(product);
		return "product added - " + product.getId();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return "deletion successful - ";
	}

}
