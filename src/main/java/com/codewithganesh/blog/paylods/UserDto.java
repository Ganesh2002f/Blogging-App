package com.codewithganesh.blog.paylods;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	
	private int Id;
	
	@NotEmpty
	@Size(min=4,message = "Username must be min of 4 charecter")
	private String name;
	
	@Email(message="Email address is not Valid!")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=10, message="password must min 3 and max 10")
	private String password;
	
	@NotEmpty
	private String about;
	
}
