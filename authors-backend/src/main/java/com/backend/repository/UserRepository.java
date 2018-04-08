package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	User findByEmail(String email);
}