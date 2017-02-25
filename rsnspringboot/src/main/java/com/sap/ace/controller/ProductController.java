package com.sap.ace.controller;

import com.sap.ace.models.Product;
import com.sap.ace.models.Rating;
import com.sap.ace.services.ProductService;
import com.sap.ace.services.dto.Request;
import com.sap.ace.services.RatingService;
import com.sap.ace.services.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ravdeep Singh on 2/20/2017.
 */

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    RatingService ratingService;

    //    @RequestMapping(value = "/products", method = RequestMethod.GET) old way
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseVO> getProducts() {
        List<Product> products = productService.findAll();
        return new ResponseEntity(new ResponseVO<>(products), HttpStatus.OK);
    }

    //    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseVO> getProductById(@PathVariable long id) {
        Product product = productService.findOne(id);
        return new ResponseEntity<ResponseVO>(new ResponseVO<Product>(product), HttpStatus.OK);
    }

    //    @RequestMapping(value = "/products/", method = RequestMethod.POST, headers = "Accept=application/json")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseVO> createProduct(@RequestBody Request<Product> product) {
        Product pro = productService.save(product.getValues());
        return new ResponseEntity<ResponseVO>(new ResponseVO(product), HttpStatus.OK);
    }

    //    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseVO> deleteProduct(@PathVariable long id) {
        productService.delete(id);
        return new ResponseEntity<ResponseVO>(new ResponseVO("{ \"message\":\"Product Deleted\"}"), HttpStatus.OK);
    }

}

