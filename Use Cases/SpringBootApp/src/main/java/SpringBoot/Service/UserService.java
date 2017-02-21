package SpringBoot.Service;

import org.springframework.stereotype.Service;

import SpringBoot.Domain.User;

/**
 * 
 * @author asingh
 */
@Service
public interface UserService {
	Iterable<User> listAllUsers();

	User getUserById(Integer id);

	User saveUser(User User);

	void deleteUser(Integer id);

}
