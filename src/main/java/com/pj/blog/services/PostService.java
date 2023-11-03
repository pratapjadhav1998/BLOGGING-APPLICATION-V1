package com.pj.blog.services;

import java.util.List;

import com.pj.blog.dtos.PostDto;
import com.pj.blog.dtos.PostResponse;
import com.pj.blog.entities.Post;

public interface PostService {
	
//	createPost
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
//	update
	
	PostDto updatePost(PostDto postDto , Integer postId);
	
//	delete
	
	void deletePost(Integer postId);
	
//	get
	
	PostDto getPostById(Integer postId);
	
//	getAll
	
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
//	getByCat
	List<PostDto> getPostByCategory(Integer categoryId);
	
//	getAllByUser
	
	List<PostDto> getPostByUser(Integer userId);
	
//	search post
	
	List<PostDto> searchPosts(String keyWord);

}
