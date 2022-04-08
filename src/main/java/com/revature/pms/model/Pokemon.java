package com.revature.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pokemon")
public class Pokemon {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="height")
	private Integer height;
	@Column(name="weight")
	private Integer weight;
	@Column(name="description")
	private String description;
	@Column(name="catch_rate")
	private Integer catchRate;
	@Column (name="sprite")
	private String sprite;
	@Column (name="type_1")
	private String type1;
	@Column (name="type_2")
	private String type2;
	
	public Pokemon() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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