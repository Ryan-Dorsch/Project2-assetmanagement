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
	@Column(name="pokeapi_id")
	private Integer pokeapiId;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="users_id", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private Users user;
	
	
	public Pokemon() {
		
	}
	
	

	public Pokemon(String nickname, Integer location, Integer pokeapiId, Users user) {
		super();
		this.nickname = nickname;
		this.location = location;
		this.pokeapiId = pokeapiId;
		this.user = user;
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


	public Integer getPokeapiId() {
		return pokeapiId;
	}


	public void setPokeapiId(Integer pokeapiId) {
		this.pokeapiId = pokeapiId;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}
	
	


	
}