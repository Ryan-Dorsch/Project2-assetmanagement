package com.revature.pms.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pms.model.User;
import com.revature.pms.repo.UsersRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(id).get();
	}

	@Override
	public void addUsers(User users) {
		// TODO Auto-generated method stub
		usersRepository.save(users);
	}

	@Override
	public void updateUsers(int id, User users) {
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




