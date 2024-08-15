package com.codewithganesh.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithganesh.blog.entities.User;
import com.codewithganesh.blog.paylods.UserDto;

public interface UserRepo extends JpaRepository<User, Integer> {

	

}
