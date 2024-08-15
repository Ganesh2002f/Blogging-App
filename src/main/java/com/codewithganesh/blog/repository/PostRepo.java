package com.codewithganesh.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithganesh.blog.entities.Category;
import com.codewithganesh.blog.entities.Post;
import com.codewithganesh.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
