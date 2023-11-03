package com.pj.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pj.blog.entities.Category;
import com.pj.blog.entities.Post;
import com.pj.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
//	Searching
	
	@Query("select p from Post p where p.title like: key")
	List<Post> findByTitleContaining(@Param("key") String title);

}
