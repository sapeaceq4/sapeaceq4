package com.sapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.domain.ProductUserRating;
import com.sapient.domain.dto.ProductUserRatingRequest;
import com.sapient.service.IRequestsHandler;
import com.sapient.util.DTOToPOJOConverter;

@RestController
@RequestMapping("/rating")
public class ProductRatingController {

	@Autowired
	IRequestsHandler<ProductUserRating, Integer> requestsHandler;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductUserRatingRequest> create(@RequestBody ProductUserRatingRequest productRatingRequest) {
		ProductUserRating product = DTOToPOJOConverter.getProductRatingFromProductRatingRequest(productRatingRequest);
		product = requestsHandler.create(product);
		productRatingRequest = DTOToPOJOConverter.getProductRatingRequestFromProductRating(product);
		return new ResponseEntity<ProductUserRatingRequest>(productRatingRequest, HttpStatus.OK);
	}
}