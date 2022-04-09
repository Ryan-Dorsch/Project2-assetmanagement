package com.revature.pms.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pms.model.Users;
import com.revature.pms.repo.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	public Users findById(int id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(id).get();
	}

	@Override
	public void addUsers(Users users) {
		// TODO Auto-generated method stub
		usersRepository.save(users);
	}

	@Override
	public void updateUsers(int id, Users users) {
		// TODO Auto-generated method stub
		usersRepository.save(users);
	}

	@Override
	public void deleteUsers(int id) {
		// TODO Auto-generated method stub
		usersRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		usersRepository.deleteAll();
	}

}




