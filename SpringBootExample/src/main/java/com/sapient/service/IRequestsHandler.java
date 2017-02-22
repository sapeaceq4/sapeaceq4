package com.sapient.service;

public interface IRequestsHandler<T, K> {
	
	T create(T elem);
	T getOne(K id);
	Iterable<T> getAll();
	T update(T elem);
	void delete(K id);
}
