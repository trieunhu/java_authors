package com.backend.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.backend.model.Post;
public interface PostService {
	public List<Post> getListPosts();
	public Post save(Post p);
	public Post updatePost(Post p);
	public void delete(Post p);
	public Post findById(Integer id);
	public Page<Post> getPage(int pageNumber);
	public Page<Post> getPageByUserId(int pageNumber,int userId);
}
