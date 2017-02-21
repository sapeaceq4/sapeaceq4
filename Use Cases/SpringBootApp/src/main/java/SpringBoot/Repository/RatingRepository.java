package SpringBoot.Repository;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import SpringBoot.Domain.Rating;

/**
 * 
 * @author asingh
 */
@Transactional
@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer> {

}
