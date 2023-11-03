package com.pj.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.blog.dtos.CommentDto;
import com.pj.blog.entities.Comment;
import com.pj.blog.entities.Post;
import com.pj.blog.exceptions.ResourceNotfoundException;
import com.pj.blog.repositories.CommentRepo;
import com.pj.blog.repositories.PostRepo;
import com.pj.blog.services.CommentService;


@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotfoundException("Post", "Post Id", postId));
		
		Comment comment=this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment= this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment=this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotfoundException("Comment", "comment Id", commentId));

		this.commentRepo.delete(comment);
	}

}
