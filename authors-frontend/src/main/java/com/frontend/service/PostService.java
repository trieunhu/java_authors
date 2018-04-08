package com.frontend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import com.frontend.model.Post;
@Transactional
public interface PostService {
	public List<Post> getListPosts();
	public List<Post> findTop3ByOrderByIdDesc();
	public Post save(Post p);
	public Post updatePost(Post p);
	public void delete(Post p);
	public Post findById(Integer id);
	public Page<Post> getPage(int pageNumber);
	public Post findBySlug(String slug);
	public List<Post> findByUserId(Integer userId,Integer limit);
	public Page<Post> getPageUserPost(int pageNumber,int userId);
}
