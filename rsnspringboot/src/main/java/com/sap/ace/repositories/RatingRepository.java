package com.sap.ace.repositories;

import com.sap.ace.models.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ravdeep Singh on 2/21/2017.
 */

@Transactional
@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

    public List<Rating> getRatingByProductId(long id);
}