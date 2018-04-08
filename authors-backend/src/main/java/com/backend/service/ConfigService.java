package com.backend.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.backend.model.Config;
@Transactional
public interface ConfigService {
	public Config save(Config c);
	public Config findByName(String name);
	public List<Config> findAll();
}
