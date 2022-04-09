package com.revature.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pms.model.PokeBox;
import com.revature.pms.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
	public List<Pokemon> findByUserId(Integer userId);
}