package SpringBoot.Repository;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import SpringBoot.Domain.User;

/**
 * 
 * @author asingh
 */
@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
