package com.dao;


import com.entity.User;

public interface UserDao {

	void save(User user);
	
	User findById(int id);
	
	User findByLogin(String login);
	
}

