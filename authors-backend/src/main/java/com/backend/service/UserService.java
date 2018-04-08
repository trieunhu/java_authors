package com.backend.service;

import com.backend.model.User;

public interface UserService {
	public void save(User u);
	public void updateUser(User u,boolean setPassword);
	public User findByUsername(String username);
	public User findByEmail(String email);
	public User getUserLogined();
}
