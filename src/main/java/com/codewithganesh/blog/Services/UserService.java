package com.codewithganesh.blog.Services;

import java.util.List;

import com.codewithganesh.blog.paylods.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);

	
	
	

}
