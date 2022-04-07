package com.revature.pms.service;

import java.util.List;

import com.revature.pms.bean.Users; 

public interface UsersService {

	public void addUsers(Users users);

	public List<Users> listUsers();
	
	public Users getUsers(int userid);
	
	public void deleteUsers(Users users);
}
