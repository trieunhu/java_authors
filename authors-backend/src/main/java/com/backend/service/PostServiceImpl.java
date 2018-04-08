package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.model.Config;
import com.backend.model.Post;
import com.backend.repository.PostRepository;
@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private ConfigService configService;
	@Override
	public List<Post> getListPosts() {
		return postRepository.findAll();
	}

	@Override
	public Post save(Post p) {
		Post p1 = p;
		return postRepository.save(p1);
	}

	@Override
	public Post updatePost(Post p) {
		return postRepository.save(p);
	}

	@Override
	public void delete(Post p) {
		// TODO Auto-generated method stub
		postRepository.delete(p);
	}
	@Transactional
	@Override
	public Post findById(Integer id) {
		// TODO Auto-generated method stub
		return postRepository.findOne(id);
	}
	public Page<Post> getPage(int pageNumber) {
		Integer numberPostBackend = 1;
		Config numberPostBackendConfig = configService.findByName("numberPostBackend");
		if(numberPostBackendConfig != null) {
			numberPostBackend = Integer.parseInt( numberPostBackendConfig.getContent());
		}
		PageRequest request = new PageRequest(pageNumber - 1, numberPostBackend, Sort.Direction.ASC, "id");
		
		return postRepository.findAll(request);
	}
	@Transactional
	@Override
	public Page<Post> getPageByUserId(int pageNumber,int userId) {
		Integer numberPostBackend = 1;
		Config numberPostBackendConfig = configService.findByName("numberPostBackend");
		if(numberPostBackendConfig != null) {
			numberPostBackend = Integer.parseInt( numberPostBackendConfig.getContent());
		}
		Pageable request = new PageRequest(pageNumber - 1, numberPostBackend, Sort.Direction.ASC, "id");
		
		return postRepository.findByUserId(userId, request);
	}
}
