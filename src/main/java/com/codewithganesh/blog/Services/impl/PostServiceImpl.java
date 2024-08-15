package com.codewithganesh.blog.Services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithganesh.blog.Services.PostService;
import com.codewithganesh.blog.entities.Category;
import com.codewithganesh.blog.entities.Post;
import com.codewithganesh.blog.entities.User;
import com.codewithganesh.blog.exception.ResourseNotFoundException;
import com.codewithganesh.blog.paylods.PostDto;
import com.codewithganesh.blog.repository.CategoryRepo;
import com.codewithganesh.blog.repository.PostRepo;
import com.codewithganesh.blog.repository.UserRepo;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourseNotFoundException("User", "User id", userId));
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("Category", "Category id", categoryId));
	
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setUser(user);
		post.setAddedDate(new Date());
		post.setCategory(category);
		
		
		Post newPost = this.postRepo.save(post);
		
		return this.modelMapper.map(newPost, PostDto.class );
		
		
		
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PostDto> getAllPost() {
		
		List<Post> allPosts = this.postRepo.findAll();
		List<PostDto> postget=  allPosts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
;		return postget;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		
		Post singlePost = this.postRepo.findById(postId).orElseThrow(()-> new ResourseNotFoundException("Post", "post id", postId));
		
		return this.modelMapper.map(singlePost, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("Category", "category id", categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat);
		
		List<PostDto> postCategory =  posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postCategory;
		
	}

	@Override
	public List<PostDto> getPosyByUser(Integer userId) {
	    
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourseNotFoundException("User", "userId", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		
		List<PostDto> postUser = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postUser;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
