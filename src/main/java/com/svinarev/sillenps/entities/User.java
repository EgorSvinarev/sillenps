package com.svinarev.sillenps.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@JoinColumn(name = "role", foreignKey = @ForeignKey(name = "role_fk"))
	@ManyToOne
	private Role role;

	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@JoinColumn(name = "gender", foreignKey = @ForeignKey(name = "gender_fk"))
	@ManyToOne
	private Gender gender;
}
