package com.revature.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.pms.model.Users;
import com.revature.pms.repo.UsersRepository;


@Service("usersService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepo;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUsers(Users users) {
		usersRepo.addUsers(users);
	}
	
	public List<Users> listUsers() {
		return usersRepo.listUsers();
	}

	public Users getUsers(int userid) {
		return usersRepo.getUsers(userid);
	}
	
	public void deleteUsers(Users users) {
		usersRepo.deleteUsers(users);
	}


		
	}


