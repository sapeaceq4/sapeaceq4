package com.sapient.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.domain.User;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
 
}