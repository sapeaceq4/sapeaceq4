package springboot.org.om.product.repositories;

import org.springframework.data.repository.CrudRepository;

import springboot.org.om.product.entity.User;

public interface UserRepository extends CrudRepository<User, Long>
{}