package com.sap.ace.controller;

import com.sap.ace.models.Rating;
import com.sap.ace.services.GenericService;
import com.sap.ace.services.RatingService;
import com.sap.ace.services.dto.Request;
import com.sap.ace.services.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Ravdeep Singh on 2/23/2017.
 */
@RestController
@RequestMapping("/products/{productId}/ratings")
public class RatingController {
    @Autowired
    private GenericService<Rating, Long> ratingService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rating>> getAllRating(@PathVariable long productId) {
        List<Rating> ratings = ((RatingService) ratingService).readAll(productId);
        return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
    }

    @GetMapping(value = "/{ratingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseVO> getRatingById(@PathVariable long productId, @PathVariable long ratingId) {
        Rating rating = ratingService.get(ratingId);
        return new ResponseEntity<ResponseVO>(new ResponseVO(rating), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseVO> createRating(@PathVariable long productId, @RequestBody Request<Rating> rating) {
        Rating newRating = ratingService.save(rating.getValues());
        return new ResponseEntity<ResponseVO>(new ResponseVO(newRating), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseVO> updateRating(@PathVariable long productId, @RequestBody Request<Rating> rating) {
        ratingService.update(rating.getValues());
        return new ResponseEntity<ResponseVO>(new ResponseVO(rating), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{ratingId}")
    public ResponseEntity<String> deletedRating(@PathVariable long productId, @PathVariable long ratingId) {
        ratingService.delete(ratingId);
        return new ResponseEntity<String>("{\"message\": \"Rating has been deleted.\"}", HttpStatus.OK);
    }
}