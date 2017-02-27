package springboot.org.om.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.org.om.product.entity.Product;
import springboot.org.om.product.entity.Rating;
import springboot.org.om.product.services.GenericService;
import springboot.org.om.product.services.dto.Request;
import springboot.org.om.product.services.dto.Response;

@RestController
@RequestMapping("/products")
public class ProductController 
{
	@Autowired
	private GenericService<Product,Long> productService;

	@Autowired
	private GenericService<Rating,Long> ratingService;

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getProducts() 
	{
		List<Product> products = productService.readAll();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductId(@PathVariable long id) 
	{
		Product product = productService.readById(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Product>> createProduct(@RequestBody Request<Product> product) 
	{
		Product newProduct =  productService.create(product.getData());
		return new ResponseEntity<Response<Product>>(new Response<Product>(newProduct), HttpStatus.CREATED);
	}

	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Product>> updateProduct(@RequestBody Request<Product> product) 
	{
		Product upadtedProduct =  productService.update(product.getData());
		return new ResponseEntity<Response<Product>>(new Response<Product>(upadtedProduct), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteProductById(@PathVariable long id) 
	{
		productService.deleteById(id);
		return new ResponseEntity<String>("{\"message\": \"Product has been deleted.\"}",HttpStatus.OK);
	}
}
