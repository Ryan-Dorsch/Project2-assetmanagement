package com.revature.pms.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.pms.model.User;


public interface UsersRepository extends JpaRepository<User, Integer> {
}

	
//	public void addUsers(Users users);
//
//	public List<Users> listUsers();
//	
//	public Users getUsers(int userid);
//	
//	public void deleteUsers(Users users); 
//}