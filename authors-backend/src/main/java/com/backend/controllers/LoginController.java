package com.backend.controllers;

import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.form.UserLogin;
@Controller
public class LoginController {
	@Autowired
	private MessageSource messageSource;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Transactional
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String actionIndex(Model m,Locale locale, Principal user) {
		if(user != null) {
			return "redirect:/";
		}
		m.addAttribute("title", messageSource.getMessage("Title.loginForm", null, locale));
		m.addAttribute("model", new UserLogin());
		return "login_index";
	}
	@RequestMapping(value = "/error",method = RequestMethod.GET)
	public String actionError(Model m,Locale locale) {
		m.addAttribute("title", messageSource.getMessage("errorPage.title", null, locale));
		return "login_error";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		logger.info("vao ham logout");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}
}
