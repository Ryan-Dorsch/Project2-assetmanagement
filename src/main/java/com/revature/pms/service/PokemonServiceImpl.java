package com.revature.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.pms.model.Pokemon;
import com.revature.pms.repo.PokemonRepository;

@Service("pokemonService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PokemonServiceImpl implements PokemonService {

	@Autowired
	PokemonRepository pokemonRepository;

	@Override
	public List<Pokemon> findAll() {
		// TODO Auto-generated method stub
		return pokemonRepository.findAll();
	}
	
	@Override
	public Pokemon findById(Integer id) {
		// TODO Auto-generated method stub
		return pokemonRepository.findById(id).get();
	}
	
	@Override
	public void addPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		pokemonRepository.save(pokemon);
	}
}