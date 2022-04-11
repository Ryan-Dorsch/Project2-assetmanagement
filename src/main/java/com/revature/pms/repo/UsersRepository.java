package com.revature.pms.repo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.pms.model.Users;


public interface UsersRepository extends JpaRepository<Users, Integer> {
		
	List<Users> findByIdIn(List<Integer> userIds);
	
	Optional<Users> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
}

	
//	public void addUsers(Users users);
//
//	public List<Users> listUsers();
//	
//	public Users getUsers(int userid);
//	
//	public void deleteUsers(Users users); 
//}