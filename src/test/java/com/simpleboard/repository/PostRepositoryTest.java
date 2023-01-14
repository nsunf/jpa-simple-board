package com.simpleboard.repository;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simpleboard.entity.PostEntity;

@SpringBootTest
public class PostRepositoryTest {
	
	@Autowired
	PostRepository repo;
	
	@Test
	@DisplayName("* insertPosts Test *")
	public void insertPosts() {
		for (int i = 1; i <= 10; i++) {
			PostEntity post = new PostEntity();
			post.setTitle("post title" + i);
			post.setContent("post content" + i);
			post.setRegDate(new Date());
			
			repo.save(post);
		}
	}
}
