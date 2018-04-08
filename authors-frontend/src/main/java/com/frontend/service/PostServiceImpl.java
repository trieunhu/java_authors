package com.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frontend.model.Config;
import com.frontend.model.Post;
import com.frontend.repository.PostRepository;
@Service("postService")
public class PostServiceImpl implements PostService {
	@Autowired
	private ConfigService configService;
	@Autowired
	private PostRepository postRepository;
	public List<Post> getListPosts() {
		return postRepository.findAll();
	}

	public Post save(Post p) {
		Post p1 = p;
		return postRepository.save(p1);
	}

	public Post updatePost(Post p) {
		return postRepository.save(p);
	}

	public void delete(Post p) {
		// TODO Auto-generated method stub
		postRepository.delete(p);
	}
	@Transactional
	public Post findById(Integer id) {
		// TODO Auto-generated method stub
		return postRepository.findOne(id);
	}
	public Page<Post> getPage(int pageNumber) {
		Integer numberPostFrontend = 1;	
		Config numberPostFrontendConfig = configService.findByName("numberPostFrontend");
		if(numberPostFrontendConfig != null) {
			numberPostFrontend = Integer.parseInt( numberPostFrontendConfig.getContent());
		}
		PageRequest request = new PageRequest(pageNumber - 1, numberPostFrontend, Sort.Direction.DESC, "id");
		
		return postRepository.findByStatus(Post.ACTIVE, request);
	}

	public Post findBySlug(String slug) {
		// TODO Auto-generated method stub
		return postRepository.findBySlug(slug);
	}

	public List<Post> findTop3ByOrderByIdDesc() {
		// TODO Auto-generated method stub
		return postRepository.findTop3ByOrderByIdDesc();
	}

	public List<Post> findByUserId(Integer userId,Integer limit) {
		// TODO Auto-generated method stub
		Pageable pa = new PageRequest(0, limit);
		return postRepository.findByUserIdAndStatusOrderByIdDesc(userId,Post.ACTIVE,pa);
	}
	
	public Page<Post> getPageUserPost(int pageNumber,int userId) {
		Integer numberPostFrontend = 1;	
		Config numberPostFrontendConfig = configService.findByName("numberPostFrontend");
		if(numberPostFrontendConfig != null) {
			numberPostFrontend = Integer.parseInt( numberPostFrontendConfig.getContent());
		}
		PageRequest request = new PageRequest(pageNumber - 1, numberPostFrontend, Sort.Direction.DESC, "id");
		
		return postRepository.findByUserIdAndStatus(userId,Post.ACTIVE, request);
	}
}
