package com.revature.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="Pokemon")
public class Pokemon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="nickname")
	private String nickname;
	@Column(name="location")
	private Integer location;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="users_id", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private Users user;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="pokemondata_id", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private PokemonData data;
	
	
	public Pokemon() {
		
	}
	
	

	public Pokemon(String nickname, Integer location, Integer pokeapiId, Users user, PokemonData data) {
		super();
		this.nickname = nickname;
		this.location = location;
		this.user = user;
		this.data = data;
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

	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}



	public PokemonData getData() {
		return data;
	}



	public void setData(PokemonData data) {
		this.data = data;
	}
	
	


	
}