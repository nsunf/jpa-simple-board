package com.simpleboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleboard.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
