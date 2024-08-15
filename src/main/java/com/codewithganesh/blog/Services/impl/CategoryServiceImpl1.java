package com.codewithganesh.blog.Services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithganesh.blog.Services.CategoryService;
import com.codewithganesh.blog.entities.Category;
import com.codewithganesh.blog.exception.ResourseNotFoundException;
import com.codewithganesh.blog.paylods.CategoryDto;
import com.codewithganesh.blog.repository.CategoryRepo;

@Service
public class CategoryServiceImpl1 implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		 Category cat = this.modelMapper.map(categoryDto, Category.class);
		 Category addedcat = this.categoryRepo.save(cat);
		 
		 return this.modelMapper.map(addedcat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
	        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("Category", "Category Id", categoryId));
	        
	        cat.setCategoryTitle(categoryDto.getCategoryTitle());
	        cat.setCategoryDescription(categoryDto.getCategoryDescription());
	        
	        Category updatedcat = this.categoryRepo.save(cat);
	        
	        return this.modelMapper.map(updatedcat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("Category", "categoryId", categoryId));
		
	    this.categoryRepo.delete(cat);
	    
	    
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("Category", "categoryId", categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		
		List<Category> categories = this.categoryRepo.findAll();
		
	    List<CategoryDto> catDtos =	categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
	    
	    return catDtos;
	}

}
