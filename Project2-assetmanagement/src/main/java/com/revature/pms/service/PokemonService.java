package com.revature.pms.service;

import java.util.List;
import com.revature.pms.bean.Pokemon;


public interface PokemonService {
	
	public void addPokemon(Pokemon pokemon);

	public List<Pokemon> listPokemonss();
	
	public Pokemon getPokemon(int pokid);
	
	public void deletePokemon(Pokemon pokemon);
}
