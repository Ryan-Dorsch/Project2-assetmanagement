package com.revature.pms.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pms.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
	List<Pokemon> findByUserId(Integer userId);
	List<Pokemon> findAllByOrderByLocation();
	@Transactional
	void deleteByUserId(Integer userId);
}