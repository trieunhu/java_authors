package com.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	Page<Post> findByUserId(Integer userId,Pageable pageable);
}
