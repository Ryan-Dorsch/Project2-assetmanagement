package com.revature.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pms.model.PokemonData;

@Repository
public interface PokemonDataRepository extends JpaRepository<PokemonData, Integer> {


}