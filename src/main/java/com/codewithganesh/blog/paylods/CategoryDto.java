package com.codewithganesh.blog.paylods;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	
	
	@Size(min=4)
	private String categoryTitle;
	
	
	@Size(min = 10)
	private String categoryDescription;
}
