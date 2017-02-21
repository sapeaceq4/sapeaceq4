package com.learn.spring.boot.jpa.repo;

import org.springframework.data.repository.CrudRepository;

import com.learn.spring.boot.jpa.model.Rating;

public interface RatingRepository extends CrudRepository<Rating, String> {

}
