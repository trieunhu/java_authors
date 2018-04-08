package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Config;
import com.backend.repository.ConfigRepository;
@Service
public class ConfigServiceImpl implements ConfigService {
	@Autowired
	private ConfigRepository configRepository;
	@Override
	public Config save(Config c) {
		// TODO Auto-generated method stub
		return configRepository.save(c);
	}

	@Override
	public Config findByName(String name) {
		// TODO Auto-generated method stub
		return configRepository.findByName(name);
	}

	@Override
	public List<Config> findAll() {
		// TODO Auto-generated method stub
		return configRepository.findAll();
	}

}
