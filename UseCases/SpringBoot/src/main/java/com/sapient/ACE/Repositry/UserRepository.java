package com.sapient.ACE.Repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.ACE.Entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	
}
