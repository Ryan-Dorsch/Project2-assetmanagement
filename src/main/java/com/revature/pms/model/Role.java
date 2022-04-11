package com.revature.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

//import com.revature.pms.model.UserRole;
//@Entity
//@Table(name = "roles")
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

@Entity
@Table(name = "roles")
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Enumerated(EnumType.STRING)
	@NaturalId
    private UserRole name;
	
	public Role() {

    }

    public Role(UserRole name) {
        this.name = name;
    }

	public UserRole getName() {
		return name;
	}

	public void setName(UserRole name) {
		this.name = name;
	}
	
	
	
}