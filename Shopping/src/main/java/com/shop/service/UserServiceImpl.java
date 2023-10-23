package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.UserRepository;
import com.shop.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;

	@Override
	public void save(User user) {
     repo.save(user);
	}

	@Override
	public List getallUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}   








}
