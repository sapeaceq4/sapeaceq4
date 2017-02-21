package com.learn.spring.boot.jpa.repo;

import org.springframework.data.repository.CrudRepository;

import com.learn.spring.boot.jpa.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
