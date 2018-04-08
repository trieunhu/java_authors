package com.backend.controllers;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.form.ConfigForm;
import com.backend.model.Config;
import com.backend.service.ConfigService;

@Controller
@RequestMapping("/config")
public class ConfigController {
	@Autowired
	private ConfigService configService;
	@Autowired
	private MessageSource messageSource;
	@RequestMapping("/")
	public String actionIndex(Model m,Locale locale) {
		m.addAttribute("title", messageSource.getMessage("configAll.Title", null, locale));
		m.addAttribute("configs", configService.findAll());
		return "config_index";
	}
	
	@RequestMapping("/create")
	public String actionCreate(Model m,Locale locale) {
		m.addAttribute("title", messageSource.getMessage("configCreate.Title", null, locale));
		String nameAppString = null,contentFooterString = null;
		Integer numberPostFrontend = 0;
		Integer numberPostBackend = 0;
		Config nameApp = configService.findByName("nameApp");
		if(nameApp != null) {
			nameAppString = nameApp.getContent();
		}
		Config contentFooter = configService.findByName("contentFooter");
		if(contentFooter != null) {
			contentFooterString = contentFooter.getContent();
		}
		Config numberPostFrontendConfig = configService.findByName("numberPostFrontend");
		if(numberPostFrontendConfig != null) {
			numberPostFrontend = Integer.parseInt( numberPostFrontendConfig.getContent());
		}
		Config numberPostBackendConfig = configService.findByName("numberPostBackend");
		if(numberPostBackendConfig != null) {
			numberPostBackend = Integer.parseInt( numberPostBackendConfig.getContent());
		}
		ConfigForm form = new ConfigForm(nameAppString,contentFooterString,numberPostBackend,numberPostFrontend);
		m.addAttribute("configCreate", form);
		return "config_create";
	}
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String actionCreateSave(Model m,Locale locale,@ModelAttribute("configCreate") @Valid ConfigForm configCreate, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "config_create";
		}
		Config nameApp = configService.findByName("nameApp");
		if(nameApp == null) {
			nameApp = new Config("nameApp", configCreate.getNameApp());
		}else {
			nameApp.setContent(configCreate.getNameApp());
		}
		configService.save(nameApp);
		Config contentFooter = configService.findByName("contentFooter");
		if(contentFooter == null) {
			contentFooter = new Config("contentFooter", configCreate.getContentFooter());
		}else {
			contentFooter.setContent(configCreate.getContentFooter());
		}
		configService.save(contentFooter);
		Config numberPostBackend = configService.findByName("numberPostBackend");
		if(numberPostBackend == null) {
			numberPostBackend = new Config("numberPostBackend", configCreate.getNumberPostBackend().toString());
		}else {
			numberPostBackend.setContent(configCreate.getNumberPostBackend().toString());
		}
		configService.save(numberPostBackend);
		Config numberPostFrontend = configService.findByName("numberPostFrontend");
		if(numberPostFrontend == null) {
			numberPostFrontend = new Config("numberPostFrontend", configCreate.getNumberPostFrontend().toString());
		}else {
			numberPostFrontend.setContent(configCreate.getNumberPostFrontend().toString());
		}
		configService.save(numberPostFrontend);
		m.addAttribute("success", 1);
		m.addAttribute("title", messageSource.getMessage("configCreate.Title", null, locale));
		return "config_create";
	}
}
