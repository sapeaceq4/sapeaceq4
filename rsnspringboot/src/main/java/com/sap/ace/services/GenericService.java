package com.sap.ace.services;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Created by Ravdeep Singh on 2/21/2017.
 */
public interface GenericService<T, ID extends Serializable> {

    public default Iterable<T> findAll() {
        return getRepository().findAll();
    }

    public default T get(ID id) {
        return getRepository().findOne(id);
    }

    public default T save(T entity) {
        return getRepository().save(entity);
    }

    public default void delete(ID id) {
            getRepository().delete(id);
    }

    public default void update(T entity) {
            getRepository().save(entity);
    }

    public CrudRepository<T, ID> getRepository();

    public ID getID(T entity);
}
