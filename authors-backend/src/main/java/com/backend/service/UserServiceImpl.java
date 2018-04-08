package com.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.common.Utils;
import com.backend.model.User;
import com.backend.repository.UserRepository;
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void save(User u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		userRepository.save(u);
		
	}
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	@Override
	public void updateUser(User u,boolean setPassword){
		if(setPassword == true) {
			u.setPassword(passwordEncoder.encode(u.getPassword()));
		}
		userRepository.save(u);
		
	}
	@Override
	public User getUserLogined() {
		String username = Utils.getUserLogined();
		return findByUsername(username);
	}
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	

}
