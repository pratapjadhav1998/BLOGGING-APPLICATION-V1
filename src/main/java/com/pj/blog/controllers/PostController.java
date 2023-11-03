package com.pj.blog.controllers;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pj.blog.config.AppConstants;
import com.pj.blog.dtos.ApiResponse;
import com.pj.blog.dtos.PostDto;
import com.pj.blog.dtos.PostResponse;
import com.pj.blog.entities.Post;
import com.pj.blog.services.FileService;
import com.pj.blog.services.PostService;

import lombok.Value;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postservice;

	@Autowired
	private FileService fileService;

//	need to correct later

//	@Value("${project.image}")
	private String path;

//	create

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {

		PostDto createdpost = this.postservice.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createdpost, HttpStatus.CREATED);

	}

//	get by user

	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<PostDto> getPostsByUser(@PathVariable Integer userId) {
		PostDto posts = (PostDto) this.postservice.getPostByUser(userId);
		return new ResponseEntity<PostDto>(HttpStatus.OK);
	}

	/*
	 * @GetMapping("/tests/{userId}") public PostDto getPostsByUser(@PathVariable
	 * Integer userId) { PostDto post = postservice.getPostById(userId);
	 * 
	 * return post;
	 * 
	 * }
	 */

//		get by category

	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {
		List<PostDto> posts = this.postservice.getPostByCategory(categoryId);
		System.out.println("h1");

		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

//	get post by id

	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
		PostDto postDto = this.postservice.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}

//	get all post

	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
		PostResponse postResponse = this.postservice.getAllPost(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}

//	delete post
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postservice.deletePost(postId);

		return new ApiResponse("post deleted sucessfully", true);

	}

//	update post

	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
		PostDto updatePost = this.postservice.updatePost(postDto, postId);

		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);

	}

//	search post

	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPosts(@PathVariable String keywords) {
		List<PostDto> result = this.postservice.searchPosts(keywords);
		return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
	}

//	post image upload

	@PostMapping(("/post/image/upload/{postId}"))
	public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image") MultipartFile image,
			@PathVariable Integer postId) throws IOException {
		PostDto postDto = this.postservice.getPostById(postId);
		String fileName = this.fileService.uploadImage(path, image);

		postDto.setImageName(fileName);
		PostDto updatedPost = this.postservice.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);

	}

//	Serve file
	@GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName9") String imageName, HttpServletResponse response)
			throws IOException {
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}

}
