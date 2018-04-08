package com.frontend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frontend.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}