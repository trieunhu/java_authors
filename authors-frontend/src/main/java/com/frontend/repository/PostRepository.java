package com.frontend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.frontend.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	Post findBySlug(String slug);
	List<Post> findTop3ByOrderByIdDesc();
	List<Post> findByUserIdOrderByIdDesc(Integer userId,Pageable pageable);
	List<Post> findByUserIdAndStatusOrderByIdDesc(Integer userId,String status,Pageable pageable);
	Page<Post> findByUserId(Integer userId,Pageable pageable);
	Page<Post> findByUserIdAndStatus(Integer userId,String status,Pageable pageable);
	Page<Post> findByStatus(String status,Pageable pageable);
}
