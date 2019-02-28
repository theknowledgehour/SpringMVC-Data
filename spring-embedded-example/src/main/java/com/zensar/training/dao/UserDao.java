package com.zensar.training.dao;

import java.util.List;

import com.zensar.training.model.User;

public interface UserDao {

	User findByName(String name);
	
	List<User> findAll();

}