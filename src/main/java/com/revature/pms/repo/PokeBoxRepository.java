package com.revature.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.pms.model.PokeBox;
import com.revature.pms.model.User;


public interface PokeBoxRepository extends JpaRepository<PokeBox, Integer> {
	
	public List<PokeBox> findByUserId(Integer userId);
}