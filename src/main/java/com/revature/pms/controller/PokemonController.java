package com.revature.pms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.pms.model.Pokemon;
import com.revature.pms.service.PokemonService;


@Controller
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView savePokemon(@ModelAttribute("command") Pokemon pokemonBean, 
			BindingResult result) {
		Pokemon pokemon = prepareModel(pokemonBean);
		pokemonService.addPokemon(pokemon);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value="/pokemons", method = RequestMethod.GET)
	public ModelAndView listPokemons() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("pokemons",  prepareListofBean(pokemonService.listPokemonss()));
		return new ModelAndView("pokemonsList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addPokemon(@ModelAttribute("command") Pokemon pokemonBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("pokemons",  prepareListofBean(pokemonService.listPokemonss()));
		return new ModelAndView("addPokemon", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editPokemon(@ModelAttribute("command") Pokemon pokemonBean,
			BindingResult result) {
		pokemonService.deletePokemon(prepareModel(pokemonBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("pokemon", null);
		model.put("pokemons",  prepareListofBean(pokemonService.listPokemonss()));
		return new ModelAndView("addPokemon", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deletePokemon(@ModelAttribute("command") Pokemon pokemonBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("pokemon", preparePokemonBean(pokemonService.getPokemon(pokemonBean.getId())));
		model.put("pokemons",  prepareListofBean(pokemonService.listPokemonss()));
		return new ModelAndView("addPokemon", model);
	}
	
	private Pokemon prepareModel(Pokemon pokemonBean){
		Pokemon pokemon = new Pokemon();
		pokemon.setId(pokemonBean.getId());
		pokemon.setName(pokemonBean.getName());
		pokemon.setHeight(pokemonBean.getHeight());
		pokemon.setWeight(pokemonBean.getWeight());
		pokemon.setCatchRate (pokemonBean.getCatchRate());
		pokemon.setDescription(pokemonBean.getDescription());
		pokemon.setSprite (pokemonBean.getSprite());
		pokemon.setType1(pokemonBean.getType1());
		pokemon.setType2(pokemonBean.getType2());
		pokemonBean.setId(null);
		return pokemon;
	}
	
	private List<Pokemon> prepareListofBean(List<Pokemon> pokemons){
		List<Pokemon> beans = null;
		if(pokemons != null && !pokemons.isEmpty()){
			beans = new ArrayList<Pokemon>();
			Pokemon bean = null;
			for(Pokemon pokemon : pokemons){
				bean = new Pokemon();
				bean.setId(pokemon.getId());
				bean.setName(pokemon.getName());
				bean.setHeight(pokemon.getHeight());
				bean.setWeight(pokemon.getWeight());
				bean.setDescription(pokemon.getDescription());
				bean.setCatchRate(pokemon.getCatchRate());
				bean.setSprite(pokemon.getSprite());
				bean.setType1(pokemon.getType1());
				bean.setType2(pokemon.getType2());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private Pokemon preparePokemonBean(Pokemon pokemon){
		Pokemon bean = new Pokemon();
		bean.setId(pokemon.getId());
		bean.setName(pokemon.getName());
		bean.setHeight(pokemon.getHeight());
		bean.setWeight(pokemon.getWeight());
		bean.setDescription(pokemon.getDescription());
		bean.setCatchRate(pokemon.getCatchRate());
		bean.setSprite(pokemon.getSprite());
		bean.setType1(pokemon.getType1());
		bean.setType2(pokemon.getType2());
		return bean;
	}
}
