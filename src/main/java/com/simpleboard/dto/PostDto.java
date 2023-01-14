package com.simpleboard.dto;

import java.text.SimpleDateFormat;

import com.simpleboard.entity.PostEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostDto {
	public Long id;
	public String title;
	public String content;
	public String regDate;
	
	public static PostDto parse(PostEntity entity) {
		PostDto dto = new PostDto();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String dateStr = sdf.format(entity.getRegDate());
		dto.setRegDate(dateStr);
		
		return dto;
	}
}
