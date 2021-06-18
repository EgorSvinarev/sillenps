package com.svinarev.sillenps.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.svinarev.sillenps.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmail(String username);
	
	Optional<User> findByUsernameOrEmail(String username, String email);
}
