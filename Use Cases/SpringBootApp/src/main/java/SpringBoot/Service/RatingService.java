package SpringBoot.Service;

import org.springframework.stereotype.Service;

import SpringBoot.Domain.Rating;

/**
 * 
 * @author asingh
 */
@Service
public interface RatingService {
	Iterable<Rating> listAllRatings();

	Rating getRatingById(Integer id);

	Rating saveRating(Rating Rating);

	void deleteRating(Integer id);

}
