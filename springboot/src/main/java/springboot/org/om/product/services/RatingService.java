package springboot.org.om.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import springboot.org.om.product.entity.Rating;
import springboot.org.om.product.repositories.RatingRepository;

@Component
public class RatingService implements GenericService<Rating, Long>
{
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public CrudRepository<Rating, Long> getRepository() 
	{
		return ratingRepository;
	}
	
	public List<Rating> readAllById(long id)
	{
		return (List<Rating>) ratingRepository.getRatingByProductId(id);
	}
}

