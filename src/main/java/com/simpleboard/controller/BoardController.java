package com.simpleboard.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simpleboard.dto.PostDto;
import com.simpleboard.entity.PostEntity;
import com.simpleboard.repository.PostRepository;


@Controller
public class BoardController {
	
	@Autowired
	PostRepository repo;
	
	public void insertDummyData() {
		List<PostEntity> postList = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			PostEntity postEntity = new PostEntity();
			postEntity.setId(Long.valueOf(i));
			postEntity.setTitle("post title" + i);
			postEntity.setContent("post content" + i);
			postEntity.setRegDate(new Date());

			postList.add(postEntity);
		}
		repo.saveAll(postList);
	}

	@GetMapping("/")
	public String main(Model model) {
//		if (repo.findAll().size() == 0) insertDummyData();

		List<PostEntity> entityList = repo.findAll();
		List<PostDto> dtoList = new ArrayList<>();
		
		entityList.stream().forEach(entity -> { 
			dtoList.add(PostDto.parse(entity));
		});

		model.addAttribute("postList", dtoList);
		return "main";
	}

	@GetMapping("/post")
	public String post(@RequestParam(name = "id", required = true) String id, Model model) {
		Long parsedId = Long.parseLong(id);
		PostEntity entity = repo.findById(parsedId).get();
		
		PostDto dto = PostDto.parse(entity);
		model.addAttribute("post", dto);
		return "post";
	}

	@GetMapping("/add")
	public String add() {
		return "add";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam String id, Model model) {
		Long parsedId = Long.parseLong(id);
		PostEntity post = repo.findById(parsedId).get();
		model.addAttribute("post", post);
		return "modify";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String id) {
		Long parsedId = Long.parseLong(id);
		repo.deleteById(parsedId);
		return "redirect:/";
	}
	
	@PostMapping("/insert")
	public String insert(@RequestParam(name = "post_title", required = true) String title, @RequestParam(name = "post_content", required = true) String content) {
		PostEntity post = new PostEntity();
		post.setTitle(title);
		post.setContent(content);
		post.setRegDate(new Date());
		
		repo.save(post);

		return "redirect:/";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam HashMap<String, String> params) {
		PostEntity post = new PostEntity();
		Long post_id = Long.parseLong(params.get("post_id"));
		String post_title = params.get("post_title");
		String post_content = params.get("post_content");
		
		post.setId(post_id);
		post.setTitle(post_title);
		post.setContent(post_content);
		post.setRegDate(new Date());
		repo.save(post);
		return "redirect:/";
	}
}