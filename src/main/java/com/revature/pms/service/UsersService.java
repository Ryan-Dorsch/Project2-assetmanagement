package com.revature.pms.service;

import java.util.List;

import com.revature.pms.model.Users;


public interface UsersService {
	
	public List<Users> findAll();

	public Users findById(int id);

	public void addUsers(Users users);

	public void updateUsers(int id, Users users);

	public void deleteUsers(int id);

	public void deleteAll();


}
