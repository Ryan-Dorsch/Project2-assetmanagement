package com.revature.pms.repo;

import java.util.List;

import com.revature.pms.bean.Pokemon;


public interface PokemonRepository {
	
	public void addPokemon(Pokemon pokemon);

	public List<Pokemon> listPokemon();
	
	public Pokemon getPokemon(int pokid);
	
	public void deletePokemon(Pokemon pokemon); 
}