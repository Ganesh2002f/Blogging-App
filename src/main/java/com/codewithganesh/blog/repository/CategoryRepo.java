package com.codewithganesh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithganesh.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	 
}
