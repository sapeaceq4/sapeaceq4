package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.domain.User;
import com.sapient.repository.UserRepository;

@Service
public class UserRequestsHandler implements IRequestsHandler<User, Integer> {

	@Autowired
	UserRepository userRepository;

	@Override
	public User create(User prod) {
		User user = userRepository.save(prod);
		return user;
	}

	@Override
	public User getOne(Integer id) {
		return userRepository.findOne(id);
	}
	
	@Override
	public Iterable<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User update(User prod) {
		User user = userRepository.save(prod);
		return user;
	}

	@Override
	public void delete(Integer id) {
		userRepository.delete(id);
	}

}
