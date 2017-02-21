package SpringBoot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBoot.Domain.User;
import SpringBoot.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Iterable<User> listAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.findOne(id);
	}

	@Override
	public User saveUser(User User) {
		return userRepository.save(User);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.delete(id);
	}

}
