package com.codewithganesh.blog.Services;

import java.util.List;

import com.codewithganesh.blog.paylods.CategoryDto;

public interface CategoryService {

	//create
	
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	//get
	public CategoryDto getCategory(Integer categoryId);
	
	
	//get All
	List<CategoryDto> getCategories();

	
}
