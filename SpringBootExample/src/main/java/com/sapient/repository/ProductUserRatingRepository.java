package com.sapient.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.domain.ProductUserRating;

@Transactional
@Repository
public interface ProductUserRatingRepository extends CrudRepository<ProductUserRating, Integer> {
 
}