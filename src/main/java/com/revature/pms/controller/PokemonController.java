package com.revature.pms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.pms.service.PokemonService;
import com.revature.pms.model.Pokemon;
import com.revature.pms.model.PokemonData;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonController {
	
	@Autowired
	PokemonService pokemonService;
	
	@GetMapping
	public List<Pokemon> findAll() {
		// TODO Auto-generated method stub
		return pokemonService.findAll();
	}

	@GetMapping("/{id}")
	public Pokemon findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return pokemonService.findById(id);
	}

	@PostMapping
	public void addPokemon(@RequestBody Pokemon pokemon) {
		// TODO Auto-generated method stub
		pokemonService.addPokemon(pokemon);
	}
//	@PutMapping("/{id}")
//	public void updatePokemon(@PathVariable int id, @RequestBody Pokemon pokemon) {
//		// TODO Auto-generated method stub
//		pokemonService.updatePokemon(id, pokemon);
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteStudent(@PathVariable int id) {
//		// TODO Auto-generated method stub
//		pokemonService.deletePokemon(id);
//	}
//
//	@DeleteMapping
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		pokemonService.deleteAll();
//	}
}