package springboot.org.om.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import springboot.org.om.product.entity.User;
import springboot.org.om.product.repositories.UserRepository;

@Component
public class UserService implements GenericService<User, Long>
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public CrudRepository<User, Long> getRepository() 
	{
		return userRepository;
	}
}
