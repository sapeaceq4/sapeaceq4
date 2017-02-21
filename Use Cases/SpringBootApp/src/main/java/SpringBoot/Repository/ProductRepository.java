package SpringBoot.Repository;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import SpringBoot.Domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author asingh
 */
@Transactional
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
