package com.sapient.ACE.service;

import com.sapient.ACE.Entities.Rating;

public interface RatingService {

	public void saveRating(Rating rating);
	public void deleteRating(int pid);
	public void updateRating(Rating user);
	public Iterable<Rating> getRatingsByProductId(int pid);
	
}
