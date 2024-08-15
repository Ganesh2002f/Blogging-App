package com.codewithganesh.blog.paylods;

import java.util.Date;

import com.codewithganesh.blog.entities.Category;
import com.codewithganesh.blog.entities.User;

import com.codewithganesh.blog.paylods.CategoryDto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	
	private String title;
	
	private String content;
 
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto categoryDto;
	
	private UserDto userDto;
	
}
