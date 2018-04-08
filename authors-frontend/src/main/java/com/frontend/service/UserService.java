package com.frontend.service;

import org.springframework.data.domain.Page;

import com.frontend.model.User;

public interface UserService {
	public void save(User u);
	public void updateUser(User u);
	public User findByUsername(String username);
	public User findByEmail(String email);
	public User findById(int id);
	public User getUserLogined();
	public Page<User> getListUser(int pageNumber);
}
