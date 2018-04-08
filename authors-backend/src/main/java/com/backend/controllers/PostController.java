package com.backend.controllers;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.backend.common.Utils;
import com.backend.form.PostForm;
import com.backend.form.validator.TypeFileValidator;
import com.backend.model.Post;
import com.backend.model.User;
import com.backend.service.PostService;
import com.backend.service.UserService;
@Transactional
@Controller
@RequestMapping("/")
public class PostController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TypeFileValidator typeFileValidator;
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	@Autowired
    private Environment environment;
	
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	@RequestMapping(value = {"/","/post","/post/index"})
	@Transactional
	public String actionIndex(Model m,@RequestParam(name = "p", defaultValue = "1") int pageNumber,Locale locale) {
		m.addAttribute("title", messageSource.getMessage("Posts.all", null, locale));
		Integer userId =  0;
		User u = userService.getUserLogined();
		if(u != null) {
			userId = u.getId();
		}
		Page<Post> page = postService.getPageByUserId(pageNumber, userId);
		m.addAttribute("posts",page.getContent());
		int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    logger.info("Begin userId:"+userId);
	    logger.info("Current:"+current);
	    logger.info("End:"+end);
	    m.addAttribute("beginIndex", begin);
	    m.addAttribute("endIndex", end);
	    m.addAttribute("currentIndex", current);
	    m.addAttribute("locale", locale);
	    m.addAttribute("messageSource", messageSource);
	    int[] a = Utils.getPagination(current, begin, end);
	    logger.info("paaaappp:"+ a[0]+" : "+a[1]+" : "+a[2]+" : "+a[3]);
	    m.addAttribute("pagination", a);
	    
	    
		return "post_index";
	}
	
	@RequestMapping("/post/create")
	public String actionCreate(Model m,Locale locale) {
		m.addAttribute("title", messageSource.getMessage("Posts.new", null, locale));
		m.addAttribute("txtSubmit", messageSource.getMessage("Create", null, locale));
		PostForm pf = new PostForm();
		m.addAttribute("createPost", pf);
		m.addAttribute("listStatus", Post.listStatus(messageSource, locale));
		return "post_create";
	}
	
	@Transactional
	@RequestMapping(value = "post/create", method = RequestMethod.POST)
	public String actionSaveCreate(@RequestParam("file") MultipartFile file,
			@ModelAttribute("createPost") @Valid PostForm createPost, BindingResult bindingResult, Model m,Locale locale) {
		typeFileValidator.setFile(file);
		typeFileValidator.validate(createPost, bindingResult);
		if (bindingResult.hasErrors()) {
			m.addAttribute("txtSubmit", messageSource.getMessage("Create", null, locale));
			m.addAttribute("title", messageSource.getMessage("Posts.new", null, locale));
			m.addAttribute("listStatus", Post.listStatus(messageSource, locale));
			return "post_create";
		}
		String nameFile = Utils.uploadFile(file, null,environment.getProperty("pathDirectoryImage"));
		Integer userId =  0;
		User u = userService.getUserLogined();
		
		logger.info("user id la:"+userId);
		String slug = Utils.makeSlug(createPost.getTitle());
		
		Post  p = new Post( createPost.getTitle(), createPost.getDescription(), createPost.getStatus(), slug);
		if(u != null) {
			p.setUser(u);
		}
		p.setSubtitle(createPost.getSubTitle());
		p.setImage(nameFile);
		p = postService.save(p);
		return "redirect:/post/update/"+p.getId();
	}
	@Transactional
	@RequestMapping("/post/update/{id}")
	public String actionUpdate(@PathVariable Integer id,Model m,Locale locale) {
		Post p = postService.findById(id);
		if(p == null) {
			return "redirect:/post/create";  
		}
		User u = userService.getUserLogined();
		if(p.getUser() == null || (p.getUser() != null &&  p.getUser().getId() != u.getId())) {
			return "redirect:/post/create";
		}
		logger.info("status la:"+p.getStatus());
		PostForm form = new PostForm(p.getTitle(),p.getDescription(),p.getStatus(),p.getSlug());
		form.setSubTitle(p.getSubtitle());
		m.addAttribute("createPost", form);
		m.addAttribute("listStatus", Post.listStatus(messageSource, locale));
		m.addAttribute("post", p);
		m.addAttribute("title", messageSource.getMessage("Posts.update", null, locale));
		m.addAttribute("txtSubmit", messageSource.getMessage("Update", null, locale));
		return "post_create";
	}
	@RequestMapping(value = "/post/update/{id}",method = RequestMethod.POST)
	public String actionSaveUpdate(@PathVariable Integer id,@RequestParam("file") MultipartFile file,
			@ModelAttribute("createPost") @Valid PostForm createPost, BindingResult bindingResult,Model m,Locale locale) {
		
		Post p = postService.findById(id);
		if(p == null) {
			return "redirect:/post/create/";  
		}
		typeFileValidator.setFile(file);
		if(!file.isEmpty()) {
			typeFileValidator.validate(createPost, bindingResult);
		}
		if (bindingResult.hasErrors()) {
			m.addAttribute("txtSubmit", messageSource.getMessage("Update", null, locale));
			m.addAttribute("createPost", createPost);
			m.addAttribute("listStatus", Post.listStatus(messageSource, locale));
			return "post_create";
		}
		p.setDescription(createPost.getDescription());
		if(!file.isEmpty()) {
			String nameFile = Utils.uploadFile(file, p.getImage(),environment.getProperty("pathDirectoryImage"));
			p.setImage(nameFile);
		}
		p.setTitle(createPost.getTitle());
		if(createPost.getSlug() != null) {
			p.setSlug(createPost.getSlug());
		}
		p.setSubtitle(createPost.getSubTitle());
		
		p.setStatus(createPost.getStatus());
		
		postService.updatePost(p);
		return "redirect:/post/update/"+p.getId();
	}
	
	@RequestMapping("/post/delete/{id}")
	public String actionDelete(@PathVariable Integer id,Model m) {
		Post p = postService.findById(id);
		if(p == null) {
			return "redirect:/post/";  
		}
		postService.delete(p);
		return "redirect:/post/";
	}
}
