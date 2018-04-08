package com.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.frontend.common.Utils;
import com.frontend.model.Config;
import com.frontend.model.User;
import com.frontend.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private ConfigService configService;
	@Autowired
	private UserRepository userRepository;

	public void save(User u) {
		userRepository.save(u);

	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public void updateUser(User u) {
		userRepository.save(u);

	}

	public User getUserLogined() {
		String username = Utils.getUserLogined();
		return findByUsername(username);
	}

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<User> getListUser(int pageNumber) {
		Integer numberPostFrontend = 1;	
		Config numberPostFrontendConfig = configService.findByName("numberPostFrontend");
		if(numberPostFrontendConfig != null) {
			numberPostFrontend = Integer.parseInt( numberPostFrontendConfig.getContent());
		}
		PageRequest request = new PageRequest(pageNumber - 1, numberPostFrontend, Sort.Direction.DESC, "id");

		return userRepository.findAll(request);
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

}
