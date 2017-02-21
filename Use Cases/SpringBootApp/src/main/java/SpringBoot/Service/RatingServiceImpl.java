package SpringBoot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBoot.Domain.Rating;
import SpringBoot.Repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Iterable<Rating> listAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public Rating getRatingById(Integer id) {
		return ratingRepository.findOne(id);
	}

	@Override
	public Rating saveRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public void deleteRating(Integer id) {
		ratingRepository.delete(id);
	}

}
