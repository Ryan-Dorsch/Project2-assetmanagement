package com.revature.pms.service;

import java.util.List;

import com.revature.pms.model.User;


public interface UserService {
	
	public List<User> findAll();

	public User findById(int id);

	public void addUsers(User users);

	public void updateUsers(int id, User users);

	public void deleteUsers(int id);

	public void deleteAll();


}
