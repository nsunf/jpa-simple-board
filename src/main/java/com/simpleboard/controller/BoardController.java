package com.simpleboard.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.simpleboard.entity.Post;


@Controller
public class BoardController {
	@GetMapping("/")
	public String main(Model model) {
		List<Post> postList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Post post = new Post();
			post.setId(Long.valueOf(i));
			post.setTitle("title" + i);
			post.setContent("content" + i);
			post.setRegDate(new Date());

			postList.add(post);
		}
		
		model.addAttribute("postList", postList);
		return "main";
	}

	@GetMapping("/add")
	public String add() {
		return "add";
	}

	@GetMapping("/edit")
	public String edit(Model model) {
		Post post = new Post();
		post.setId(1L);
		post.setTitle("title");
		post.setContent("content");
		post.setRegDate(new Date());
		model.addAttribute("post", post);
		return "modify";
	}
	
	@GetMapping("/post")
	public String post(Model model) {
		Post post = new Post();
		post.setId(1L);
		post.setTitle("title");
		post.setContent("content");
		post.setRegDate(new Date());
		model.addAttribute("post", post);
		return "post";
	}
	
}