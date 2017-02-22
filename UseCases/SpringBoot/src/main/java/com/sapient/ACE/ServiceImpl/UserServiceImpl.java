package com.sapient.ACE.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.ACE.Entities.User;
import com.sapient.ACE.Repositry.UserRepository;
import com.sapient.ACE.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User getUser(int uid) {
		return userRepository.findOne(uid);
	}

	@Override
	public void deleteUser(int uid) {
		userRepository.delete(uid);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

}
