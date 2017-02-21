package com.sap.ace.services;

import com.sap.ace.models.Product;
import com.sap.ace.models.User;
import com.sap.ace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Ravdeep Singh on 2/21/2017.
 */
@Component
public class UserService implements GenericService<User, Long> {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User findOne(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public CrudRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public Long getID(User entity) {
        return null;
    }
}
