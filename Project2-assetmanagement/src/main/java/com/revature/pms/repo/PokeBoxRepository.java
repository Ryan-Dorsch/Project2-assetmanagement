package com.revature.pms.repo;

import java.util.List;

import com.revature.pms.bean.PokeBox;


public interface PokeBoxRepository {
	
	public void addPokeBox(PokeBox pokeBox);

	public List<PokeBox> listPokeBox();
	
	public PokeBox getPokeBox(int BoxNumber);
	
	public void deletePokemon(PokeBox pokeBox); 
}