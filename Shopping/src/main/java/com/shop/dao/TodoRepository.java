package com.shop.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shop.model.ToDo;
@Repository
public interface TodoRepository extends CrudRepository<ToDo, Integer> {

	
	
	 ToDo findByTitle(String title);
}
