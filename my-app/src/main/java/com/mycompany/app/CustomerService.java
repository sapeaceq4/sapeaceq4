package com.mycompany.app;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.datamodel.Product;
import com.mycompany.datamodel.ResponseVO;
import com.mycompany.service.ProductService;

@RestController
@RequestMapping("/product")
public class CustomerService {
	
	private final ProductService productService;
	
	public CustomerService(final ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(value = "getCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCustomer(){
		return "new customer";
	}
	
	@GetMapping(value = "/getAllProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<List<Product>>> getAll() {
		Iterable<Product> savedProduct = productService.findAll();
		List<Product> products = new ArrayList<Product>();
		savedProduct.forEach( p -> products.add(p));
		return ResponseEntity.created(URI.create("/getAllProduct" )).body(new ResponseVO<>(products));
	}
	
	@GetMapping(value = "/getById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Product>> getById(@RequestParam String id) {
		Product product = productService.get(id);
		
	
		return ResponseEntity.created(URI.create("/getById" )).body(new ResponseVO<>(product));
	}
	
	
	@GetMapping(value = "/getByName", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Iterable<Product>>> getByName(@RequestParam String productName) {
		Iterable<Product> product = productService.findByName(productName);
		System.out.println("product "+product);
		return ResponseEntity.created(URI.create("/getByName" )).body(new ResponseVO<>(product));
	}
	
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<Product>> create(@RequestBody Product product) {
		Product savedProduct = productService.save(product);
		return ResponseEntity.created(URI.create("/" + product.getId())).body(new ResponseVO<>(savedProduct));
	}

}
