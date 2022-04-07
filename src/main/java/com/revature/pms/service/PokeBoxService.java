package com.revature.pms.service;

import java.util.List;
import com.revature.pms.bean.PokeBox;


public interface PokeBoxService {
	
	public void addPokeBox(PokeBox pokeBox);

	public List<PokeBox> listPokeBoxss();
	
	public PokeBox getPokeBox(int boxNumber);
	
	public void deletePokeBox(PokeBox pokeBox);
}
