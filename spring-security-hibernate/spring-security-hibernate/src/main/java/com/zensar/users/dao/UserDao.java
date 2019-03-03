package com.zensar.users.dao;

import com.zensar.users.model.User;

public interface UserDao {

	User findByUserName(String username);

}