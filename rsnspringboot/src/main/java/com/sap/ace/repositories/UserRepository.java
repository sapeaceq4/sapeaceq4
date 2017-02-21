package com.sap.ace.repositories;

import com.sap.ace.models.Product;
import com.sap.ace.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ravdeep Singh on 2/20/2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}