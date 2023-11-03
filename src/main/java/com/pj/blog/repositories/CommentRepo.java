package com.pj.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pj.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
