package com.svinarev.sillenps.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.svinarev.sillenps.repositories.UserRepository;
import com.svinarev.sillenps.entities.User;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = repository.findByUsername(username);
		
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return user.get();
	}
	
	public Optional<User> findUserById(Long id) {
		Optional<User> user = repository.findById(id);
		return user;
	}
	
	public boolean delete(Long id) {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	/** 
	 * Save the entity to the database without checking 
	 * for existing entries with this id, username and email
	*/
	public void update(User user) {
		repository.save(user);
	}
	
	/** 
	 * Save the entity to the database with checking for 
	 * existing entries with these email and username. This 
	 * method is implemented for a process of user's registration 
	 * in the system.
	*/
	public boolean save(User user, Role role) {
		Optional<User> storedUser = repository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
		
		if (storedUser.isPresent()) {
			return false;
		}
		
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(role);
		
		repository.save(user);
		
		return true;
	}
	
}
