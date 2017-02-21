package com.example.Repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Entity.Product;
import com.example.Entity.User;

@Repository
public class Repo {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String insert="insert into user(user_id,first_name,last_name,city) values(?,?,?,?)";
	String insertProduct="insert into product(product_id,name,size,color,average_rating) values(?,?,?,?,?)";



	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Transactional
	public int saveUser(User user)
	{
		Object[] array={user.getUser_id(),user.getFirstName(),user.getLastName(),user.getCity()};
		jdbcTemplate.update(insert,array);

		return 1;
	}
	
	@Transactional
	public int saveProduct(Product product)
	{
		Object[] array={product.getProduct_id(),product.getName(),product.getSize(),product.getColor(),product.getAverageRating()};
		jdbcTemplate.update(insertProduct,array);

		return 1;
	}
	

}
