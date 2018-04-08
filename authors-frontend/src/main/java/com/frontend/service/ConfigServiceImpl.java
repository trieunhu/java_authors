package com.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frontend.model.Config;
import com.frontend.repository.ConfigRepository;

@Service
public class ConfigServiceImpl implements ConfigService {
	@Autowired
	private ConfigRepository configRepository;
	
	public Config save(Config c) {
		// TODO Auto-generated method stub
		return configRepository.save(c);
	}

	public Config findByName(String name) {
		// TODO Auto-generated method stub
		return configRepository.findByName(name);
	}

	public List<Config> findAll() {
		// TODO Auto-generated method stub
		return configRepository.findAll();
	}

}
