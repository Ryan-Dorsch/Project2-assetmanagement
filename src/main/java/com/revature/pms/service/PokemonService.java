package com.revature.pms.service;

import java.util.List;

import com.revature.pms.model.Pokemon;
import com.revature.pms.model.PokemonData;

public interface PokemonService {
	
	public List<Pokemon> findAll();

	public Pokemon findById(Integer id);

	public void addPokemon(Pokemon pokemon);

//	public void updatePokemon(int id, Pokemon pokemon);
//
//	public void deletePokemon(int id);
//
//	public void deleteAll();
}
