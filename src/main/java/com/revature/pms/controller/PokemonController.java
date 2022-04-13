package com.revature.pms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.revature.pms.exception.AppException;
import com.revature.pms.model.Pokemon;
import com.revature.pms.payload.ApiResponse;
import com.revature.pms.repo.PokemonRepository;
import com.revature.pms.repo.UsersRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonController {
	
	@Autowired
	PokemonService pokemonService;
	
	@Autowired
	PokemonRepository pokeRepo;
	@Autowired
	UsersRepository userRepo;
	
	@GetMapping("/users/{userId}/pokemon")
	public ResponseEntity<List<Pokemon>> getAllPokemonByPokemonId(@PathVariable(value = "userId") Integer userId) {
		if (!userRepo.existsById(userId)) {
		      throw new AppException("User not found with id = " + userId);
	    }
		List<Pokemon> pokemon = pokeRepo.findByUserId(userId);
		return new ResponseEntity<>(pokemon, HttpStatus.OK);
	}
	
	@GetMapping("/pokemon/{id}")
	public ResponseEntity<Pokemon> getPokemonByUserId(@PathVariable(value = "id") Integer id) {
		Pokemon pokemon = pokeRepo.findById(id)
				.orElseThrow(() -> new AppException("Pokemon not found with id = " + id));
//		if(!pokeRepo.existsById(id)) {
//            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Username is already taken!"),
//                    HttpStatus.BAD_REQUEST);
//        }
	    return new ResponseEntity<>(pokemon, HttpStatus.OK);
	}
	@PostMapping("/users/{userId}/pokemon")
	public ResponseEntity<Pokemon> createPokemon(@PathVariable(value = "userId") Integer userId, @RequestBody Pokemon pokeRequest) {
		Pokemon pokemon = userRepo.findById(userId).map(user -> {
			pokeRequest.setUser(user);
			return pokeRepo.save(pokeRequest);
		}).orElseThrow(() -> new AppException("User not found with id = " + userId));
	    return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
	  }
	@PutMapping("/pokemon/{id}")
	public ResponseEntity<Pokemon> update(@PathVariable("id") Integer id, @RequestBody Pokemon pokemonRequest) {
		Pokemon pokemon = pokeRepo.findById(id)
				.orElseThrow(() -> new AppException("PokemonId " + id + "not found"));
		
		// add field to update
	    return new ResponseEntity<>(pokeRepo.save(pokemon), HttpStatus.OK);
	  }
	@DeleteMapping("/pokemon/{id}")
	public ResponseEntity<HttpStatus> deletePokemon(@PathVariable("id") Integer id) {
		pokeRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@DeleteMapping("/users/{userId}/pokemon")
	public ResponseEntity<List<Pokemon>> deleteAllCommentsOfTutorial(@PathVariable(value = "userId") Integer userId) {
	  if (!userRepo.existsById(userId)) {
		  throw new AppException("User not found with id = " + userId);
	  }
	  pokeRepo.deleteByUserId(userId);
	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
//	@GetMapping
//	public List<Pokemon> findAll() {
//		// TODO Auto-generated method stub
//		return pokemonService.findAll();
//	}
//
//	@GetMapping("/{id}")
//	public Pokemon findById(@PathVariable int id) {
//		// TODO Auto-generated method stub
//		return pokemonService.findById(id);
//	}
//
//	@PostMapping
//	public void addPokemon(@RequestBody Pokemon pokemon) {
//		// TODO Auto-generated method stub
//		pokemonService.addPokemon(pokemon);
//	}
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