package com.pj.blog.dtos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.pj.blog.entities.Category;
import com.pj.blog.entities.Comment;
import com.pj.blog.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class PostDto {

	private Integer postId;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private Category category;
	private User user;
	
	
	private Set<CommentDto> comments = new HashSet<>();
}
