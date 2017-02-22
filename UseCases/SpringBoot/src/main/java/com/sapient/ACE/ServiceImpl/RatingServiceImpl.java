package com.sapient.ACE.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.ACE.Entities.Rating;
import com.sapient.ACE.Repositry.RatingRepository;
import com.sapient.ACE.service.RatingService;


@Service("ratingService")
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public void saveRating(Rating rating) {
		ratingRepository.save(rating);
	}

	@Override
	public Iterable<Rating> getRatingsByProductId(int pid) {
		return ratingRepository.getRatingsByProductId(pid);
	}

	@Override
	public void deleteRating(int rid) {
		ratingRepository.delete(rid);
	}

	@Override
	public void updateRating(Rating rating) {
		ratingRepository.save(rating);
	}

}
