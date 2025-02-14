package com.codewithganesh.blog.Contollers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithganesh.blog.Services.UserService;
import com.codewithganesh.blog.paylods.ApiResponse;
import com.codewithganesh.blog.paylods.UserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//POST - CREATE USER
	@PostMapping("/")
	public ResponseEntity<UserDto> createUsers(@Valid @RequestBody UserDto userDto)
	{
		UserDto createdUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	}
	
	
	//PUT - UPDATE USER
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid)
	{
	         UserDto updatedUser = this.userService.updateUser(userDto, uid);
	         
	         return ResponseEntity.ok(updatedUser);
	}
	
	
	//DELETE - DELETE USER
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUSer(@PathVariable("userId") Integer uid)
	{
		 this.userService.deleteUser(uid);
		 return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully", true),HttpStatus.OK);
	}
	
	
	//GET - USER GET
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	
	//GET - ONE USER
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser (@PathVariable Integer userId)
	{
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	
	
	
	
 }
