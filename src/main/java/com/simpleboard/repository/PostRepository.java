package com.simpleboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleboard.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
