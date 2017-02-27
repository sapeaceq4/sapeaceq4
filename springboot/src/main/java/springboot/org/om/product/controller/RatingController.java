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

import springboot.org.om.product.entity.Rating;
import springboot.org.om.product.services.GenericService;
import springboot.org.om.product.services.RatingService;
import springboot.org.om.product.services.dto.Request;
import springboot.org.om.product.services.dto.Response;

@RestController
@RequestMapping("/products/{productId}/ratings")
public class RatingController 
{
	@Autowired
	private GenericService<Rating,Long> ratingService;

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Rating>> getAllRating(@PathVariable long productId) 
	{
		List<Rating> ratings = ((RatingService)ratingService).readAllById(productId);
		return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
	}
	
	@GetMapping(value="/{ratingId}" , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rating> getRatingById(@PathVariable long productId, @PathVariable long ratingId) 
	{
		Rating rating = ratingService.readById(ratingId);
		return new ResponseEntity<Rating>(rating, HttpStatus.OK);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Rating>> createRating(@PathVariable long productId, @RequestBody Request<Rating> rating) 
	{
		 Rating newRating =  ratingService.create(rating.getData());
		 return new ResponseEntity<Response<Rating>>(new Response<Rating>(newRating), HttpStatus.CREATED);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Rating>> updateRating(@PathVariable long productId, @RequestBody Request<Rating> rating) 
	{
		Rating upadtedRating =  ratingService.update(rating.getData());
		return new ResponseEntity<Response<Rating>>(new Response<Rating>(upadtedRating), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{ratingId}")
	public ResponseEntity<String> deletedRating(@PathVariable long productId, @PathVariable long ratingId) 
	{
		 ratingService.deleteById(ratingId);
		 return new ResponseEntity<String>("{\"message\": \"Rating has been deleted.\"}",HttpStatus.OK);
	}
}
