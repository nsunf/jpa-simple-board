package com.simpleboard.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Post {
	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(name = "post_title")
	public String title;
	
	@Column(name = "post_content")
	public String content;
	
	@Column(name = "post_regdate")
	public Date regDate;
}
