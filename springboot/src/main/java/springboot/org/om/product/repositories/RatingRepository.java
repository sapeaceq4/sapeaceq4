package springboot.org.om.product.repositories;

import org.springframework.data.repository.CrudRepository;

import springboot.org.om.product.entity.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long>
{
	public Iterable<Rating> getRatingByProductId(long productId);
}
