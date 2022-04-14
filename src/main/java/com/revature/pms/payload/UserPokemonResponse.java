package com.revature.pms.payload;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.revature.pms.model.Pokemon;
import com.revature.pms.model.PokemonData;

public class UserPokemonResponse implements Serializable {

	private Integer id;
	private String nickname;
	private Integer location;
	private String name;
	private Integer height;
	private Integer weight;
	private String description;
	private Integer catchRate;
	private String sprite;
	private String type1;
	private String type2;
	
	public UserPokemonResponse() {
		super();
	}
	
	public UserPokemonResponse(Pokemon p, PokemonData d) {
		super();
		this.id = p.getId();
		this.nickname = p.getNickname();
		this.location = p.getLocation();
		this.name = d.getName();
		this.height = d.getHeight();
		this.weight = d.getWeight();
		this.description = d.getDescription();
		this.catchRate = d.getCatchRate();
		this.sprite = d.getSprite();
		this.type1 = d.getType1();
		this.type2 = d.getType2();
		
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCatchRate() {
		return catchRate;
	}
	public void setCatchRate(Integer catchRate) {
		this.catchRate = catchRate;
	}
	public String getSprite() {
		return sprite;
	}
	public void setSprite(String sprite) {
		this.sprite = sprite;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	
	
	
}
