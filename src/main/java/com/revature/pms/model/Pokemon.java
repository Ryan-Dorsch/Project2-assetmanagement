package com.revature.pms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pokemon")
public class Pokemon {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nickname;
	private Integer location;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pokemondata_id", nullable = false)
    private PokemonData pokemonData;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public Pokemon() {
		
	}
	
	
	public Pokemon(String nickname, Integer location, User user, PokemonData pokemonData) {
		super();
		this.nickname = nickname;
		this.location = location;
		this.user = user;
		this.pokemonData = pokemonData;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getLocation() {
		return location;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
	public PokemonData getPokemonData() {
		return pokemonData;
	}
	public void setPokemonData(PokemonData pokemonData) {
		this.pokemonData = pokemonData;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
}
