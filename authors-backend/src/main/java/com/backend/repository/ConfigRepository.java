package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.Config;

public interface ConfigRepository extends JpaRepository<Config, Integer> {
	Config findByName(String name);
}
