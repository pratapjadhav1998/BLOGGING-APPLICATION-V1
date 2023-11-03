package com.pj.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pj.blog.dtos.ApiResponse;
import com.pj.blog.dtos.CommentDto;
import com.pj.blog.entities.Comment;
import com.pj.blog.services.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId)
	{
		CommentDto createdComment=this.commentService.createComment(comment, postId);
		
		return new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);
		
	}
	
	
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment( @PathVariable Integer commentId)
	{
		this.commentService.deleteComment(commentId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("comment deleted successfully", true), HttpStatus.OK);
		
	}
	
	
}
