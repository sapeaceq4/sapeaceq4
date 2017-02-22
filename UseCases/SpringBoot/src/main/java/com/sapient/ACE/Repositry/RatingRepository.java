package com.sapient.ACE.Repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.ACE.Entities.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer>{


	public Iterable<Rating> getRatingsByProductId(int pid);

	
}
