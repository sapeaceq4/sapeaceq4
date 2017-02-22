package com.sapient.ACE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.ACE.Entities.Product;
import com.sapient.ACE.Entities.Rating;
import com.sapient.ACE.service.ProductService;
import com.sapient.ACE.service.RatingService;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

	@Autowired
	@Qualifier("prodService")
	private ProductService productService;

	@Autowired
	@Qualifier("ratingService")
	private RatingService ratingService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	String save(@RequestBody Product product) {
		productService.saveProduct(product);
		return "Saved";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	String get(@PathVariable int prodId) {
		Product p = productService.getProduct(prodId);
		return p.toString();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	String delete(@PathVariable int prodId) {
		productService.deleteProduct(prodId);
		return "Deleted";
	}

	@RequestMapping(value = "/{pid}/Ratings", method = RequestMethod.GET)
	Iterable<Rating> getProductRatings(@PathVariable int pid) {
		return ratingService.getRatingsByProductId(pid);
	}

	@RequestMapping(value = "/{pid}/Ratings", method = RequestMethod.POST)
	String saveRating(@RequestBody Rating rating, @PathVariable int pid) {
		rating.setProductId(pid);
		ratingService.saveRating(rating);
		return "Saved Rating";
	}

	@RequestMapping(value = "/{pid}/Ratings/{rid}", method = RequestMethod.DELETE)
	String deleteRating(@PathVariable int pid, @PathVariable int rid) {
		productService.deleteProduct(rid);
		return "Deleted";
	}
}
