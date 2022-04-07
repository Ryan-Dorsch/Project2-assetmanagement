package com.revature.pms.repo;

import java.util.List;

import com.revature.pms.bean.Users;


public interface UsersRepository {
	
	public void addUsers(Users users);

	public List<Users> listUsers();
	
	public Users getUsers(int userid);
	
	public void deleteUsers(Users users); 
}