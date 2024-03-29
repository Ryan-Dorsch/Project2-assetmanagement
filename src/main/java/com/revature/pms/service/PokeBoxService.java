package com.revature.pms.service;

import java.util.List;

import com.revature.pms.model.PokeBox;


public interface PokeBoxService {
	
	public void addPokeBox(PokeBox pokeBox);

	public List<PokeBox> findAll();
	
	public PokeBox findById(Integer boxNumber);
	
	public void deletePokeBox(PokeBox pokeBox);
}
