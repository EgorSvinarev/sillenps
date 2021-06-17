package com.svinarev.sillenps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.svinarev.sillenps.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsernameAndEmail(String username, String email);
}
