package com.backend.controllers;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.backend.common.Utils;
import com.backend.form.ChangePassword;
import com.backend.form.UserCreate;
import com.backend.form.UserUpdate;
import com.backend.form.validator.TypeFileValidator;
import com.backend.model.User;
import com.backend.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TypeFileValidator typeFileValidator;
	@Autowired
	private UserService userService;
	@Autowired
    private Environment environment;
	@Transactional
	@RequestMapping("/changepassword")
	public String actionChangePassword(Model m,Locale locale) {
		m.addAttribute("changePassword",new ChangePassword());
		m.addAttribute("title", messageSource.getMessage("changePassword.Title", null, locale));
		return "user_changepassword";
	}
	@Transactional
	@RequestMapping(value = "/changepassword",method = RequestMethod.POST)
	public String actionSaveChangePassword(@ModelAttribute("changePassword") @Valid ChangePassword model,BindingResult bindingResult,Model m) {
		if(bindingResult.hasErrors()) {
			logger.info("da co1 loi");
			return "user_changepassword";
		}
		User u = userService.getUserLogined();
		if(u != null) {
			u.setPassword(model.getNewPassword());
			userService.updateUser(u,true);
			m.addAttribute("success", 1);
		}
		
		m.addAttribute("changePassword",new ChangePassword());
		return "user_changepassword";
	}
	@Transactional
	@RequestMapping("/update")
	public String actionUpdate(Model m,Locale locale) {
		String username = Utils.getUserLogined();
		User u = userService.findByUsername(username);
		m.addAttribute("userUpdate",new UserUpdate(u.getEmail(), u.getFullname()));
		m.addAttribute("user",u);
		m.addAttribute("title", messageSource.getMessage("userUpdate.Title", null, locale));
		return "user_update";
	}
	@Transactional
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String actionUpdateUser(@RequestParam("file") MultipartFile file,@ModelAttribute("userUpdate") @Valid UserUpdate userUpdate,BindingResult bindingResult,Model m,Locale locale) {
		typeFileValidator.setFile(file);
		if(!file.isEmpty()) {
			typeFileValidator.validate(userUpdate, bindingResult);
		}
		if(bindingResult.hasErrors()) {
			m.addAttribute("title", messageSource.getMessage("userUpdate.Title", null, locale));
			logger.info("da co1 loi");
			return "user_update";
		}
		String username = Utils.getUserLogined();
		User u = userService.findByUsername(username);
		if(!file.isEmpty()) {
			String nameFile = Utils.uploadFile(file,u.getAvatar(),environment.getProperty("pathDirectoryImage"));
			u.setAvatar(nameFile);
		}
		if(u != null) {
			u.setEmail(userUpdate.getEmail());
			u.setFullname(userUpdate.getFullname());
			userService.updateUser(u,false);
			m.addAttribute("success", 1);
		}
		m.addAttribute("userUpdate",userUpdate);
		return "redirect:/user/update";
	}
	@RequestMapping("/create")
	public String actionCreate(Model m,Locale locale) {
		m.addAttribute("userCreate",new UserCreate());
		m.addAttribute("title", messageSource.getMessage("userCreate.Title", null, locale));
		return "user_create";
	}
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String actionCreateUser(@ModelAttribute("userCreate") @Valid UserCreate userCreate,BindingResult bindingResult,Model m,Locale locale) {
		if(bindingResult.hasErrors()) {
			logger.info("da co1 loi");
			m.addAttribute("title", messageSource.getMessage("userCreate.Title", null, locale));
			m.addAttribute("userCreate",userCreate);
			return "user_create";
		}
		User u = new User(userCreate.getUsername(), userCreate.getEmail(), userCreate.getPassword());
		u.setFullname(userCreate.getFullname());
		logger.info("full name la"+userCreate.getFullname());
		userService.save(u);
		m.addAttribute("success", 1);
		m.addAttribute("userCreate",new UserCreate());
		return "user_create";
	}
}
