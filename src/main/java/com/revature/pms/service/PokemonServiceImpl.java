package com.revature.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.pms.repo.PokemonRepository;
import com.revature.pms.bean.Pokemon;


@Service("pokemonService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PokemonServiceImpl implements PokemonService {

	@Autowired
	private PokemonRepository pokemonRepo;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPokemon(Pokemon pokemon) {
		pokemonRepo.addPokemon(pokemon);
	}
	
	public List<Pokemon> listPokemonss() {
		return pokemonRepo.listPokemon();
	}

	public Pokemon getPokemon(int pokid) {
		return pokemonRepo.getPokemon(pokid);
	}
	
	public void deletePokemon(Pokemon pokemon) {
		pokemonRepo.deletePokemon(pokemon);
	}

}