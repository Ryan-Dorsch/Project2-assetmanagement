package com.revature.pms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pms.model.PokemonData;

@Repository
public interface PokemonDataRepository extends JpaRepository<PokemonData, Integer> {
	Optional<PokemonData> findByName(String name);

}