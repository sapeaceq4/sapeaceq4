package com.sapient.ACE.service;

import com.sapient.ACE.Entities.User;

public interface UserService {

	public void saveUser(User user);
	public User getUser(int pid);
	public void deleteUser(int pid);
	public void updateUser(User user);
	
}
