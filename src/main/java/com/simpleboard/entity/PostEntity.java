package com.simpleboard.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "post")
@Getter
@Setter
@ToString
public class PostEntity {
	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "post_title")
	private String title;
	
	@Column(name = "post_content")
	private String content;
	
	@Column(name = "post_regdate")
	private Date regDate;
}
