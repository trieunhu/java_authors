package com.frontend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frontend.model.Config;


public interface ConfigRepository extends JpaRepository<Config, Integer> {
	Config findByName(String name);
}
