package com.frontend.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frontend.common.Utils;
import com.frontend.model.Post;
import com.frontend.model.User;
import com.frontend.service.PostService;
import com.frontend.service.UserService;


@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/","/post/{id}","/post/"})
	public String actionIndex(@PathVariable(name="id",required = false) Integer id,Model m,Locale locale) {
		m.addAttribute("title", messageSource.getMessage("all_posts", null, locale));
		logger.info("id la:"+id);
		if(id == null) id = 1;
				
		Page<Post> page = postService.getPage(id);
		m.addAttribute("posts",page.getContent());
		int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    m.addAttribute("beginIndex", begin);
	    m.addAttribute("endIndex", end);
	    m.addAttribute("currentIndex", current);
	    int[] a = Utils.getPagination(current, begin, end);
	    logger.info("paaaappp:"+ a[0]+" : "+a[1]+" : "+a[2]+" : "+a[3]);
	    m.addAttribute("pagination", a);
		return "home_index";
	}
	
	@RequestMapping(value= {"chi-tiet/{slug}"})
	public String actionDetails(@PathVariable(name="slug",required = false) String slug,Model m) {
		Post p = postService.findBySlug(slug);
		if(p != null) {
			p.setViews(p.getViews() + 1);
			postService.save(p);
			m.addAttribute("post", p);
			m.addAttribute("title", p.getTitle());
			m.addAttribute("postsDesc", postService.findTop3ByOrderByIdDesc());
			User u = p.getUser();
			if(u != null) {
				m.addAttribute("user", u);
				m.addAttribute("postsAuthor", postService.findByUserId(u.getId(), 5));
			}
		}
		return "home_details";
	}
	
	@RequestMapping(value= {"tac-gia/","tac-gia/{p}"})
	public String actionAuthors(@PathVariable(name="p",required = false) Integer p,Model m,Locale locale) {
		m.addAttribute("title", messageSource.getMessage("all_authors", null, locale));
		if(p == null) p = 1;
		Page<User> page = userService.getListUser(p);
		m.addAttribute("users",page.getContent());
		int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    m.addAttribute("beginIndex", begin);
	    m.addAttribute("endIndex", end);
	    m.addAttribute("currentIndex", current);
	    int[] a = Utils.getPagination(current, begin, end);
	    logger.info("paaaappp:"+ a[0]+" : "+a[1]+" : "+a[2]+" : "+a[3]);
	    m.addAttribute("pagination", a);
		return "home_authors";
	}
	@RequestMapping(value= {"/chi-tiet-tac-gia/{id}","/chi-tiet-tac-gia/{id}/{page}"})
	public String actionAuthorDetails(@PathVariable(name="page",required = false) Integer pageNumber,@PathVariable(name="id",required = false) Integer id,Model m,Locale locale) {
		logger.info("id la:"+id);
		if(id == null) id = 1;
		if(pageNumber == null) pageNumber = 1;
		User u = userService.findById(id);
		if(u == null) {
			
		}
		m.addAttribute("title", messageSource.getMessage("all_postsbyauthor", new String[] {u.getFullname()}, locale));
		Page<Post> page = postService.getPageUserPost(pageNumber,id);
		m.addAttribute("posts",page.getContent());
		int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    m.addAttribute("beginIndex", begin);
	    m.addAttribute("endIndex", end);
	    m.addAttribute("currentIndex", current);
	    m.addAttribute("link", "/chi-tiet-tac-gia/"+id+"/");
	    int[] a = Utils.getPagination(current, begin, end);
	    logger.info("paaaappp:"+ a[0]+" : "+a[1]+" : "+a[2]+" : "+a[3]);
	    m.addAttribute("pagination", a);
		return "home_authors_details";
	}
}
