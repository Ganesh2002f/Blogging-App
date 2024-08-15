package com.codewithganesh.blog.Services;

import java.util.List;

import com.codewithganesh.blog.entities.Post;
import com.codewithganesh.blog.paylods.PostDto;

public interface PostService {
	
	
	
	//create 
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all posts
	
	List<PostDto> getAllPost();
	
	//get post by id
	
	PostDto getPostById(Integer postId);
	
	//get all post by category
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get all post by user
	
	List<PostDto> getPosyByUser(Integer userId);
	
	
	//search posts
	List<Post> searchPosts(String keyword);
	
	
	


}
