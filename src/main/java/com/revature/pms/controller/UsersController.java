package com.revature.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pms.model.User;
import com.revature.pms.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:8080")
public class UsersController{

	@Autowired
	UserService usersService;

	@GetMapping
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return usersService.findAll();
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return usersService.findById(id);
	}

	@PostMapping
	public void addUsers(@RequestBody User users) {
		// TODO Auto-generated method stub
		usersService.addUsers(users);
	}
//	@PutMapping("/Users/{id}")
//	public void updateStudent(@PathVariable int id, @RequestBody Users users) {
//		// TODO Auto-generated method stub
//		usersService.updateUsers(id, users);
//	}
//
//	@DeleteMapping("/students/{id}")
//	public void deleteStudent(@PathVariable int id) {
//		// TODO Auto-generated method stub
//		studentService.deleteStudent(id);
//	}
//
//	@DeleteMapping("/students")
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		studentService.deleteAll();
//	}
}
