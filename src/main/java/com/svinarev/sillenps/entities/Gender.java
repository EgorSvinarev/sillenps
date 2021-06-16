package com.svinarev.sillenps.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Positive;

@Entity
@Table(name = "genders")
public class Gender {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Positive
	private int id;
	
	@Column(name = "name")
	private String name;

}
