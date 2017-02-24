package com.sap.ace.services;

import com.sap.ace.models.Rating;
import com.sap.ace.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Ravdeep Singh on 2/21/2017.
 */
@Component
public class RatingService implements GenericService<Rating, Long> {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public CrudRepository<Rating, Long> getRepository() {
        return ratingRepository;
    }

    @Override
    public Long getID(Rating entity) {
        return null;
    }

    public List<Rating> readAll(long id) {
        return  ratingRepository.getRatingByProductId(id);
    }
}
