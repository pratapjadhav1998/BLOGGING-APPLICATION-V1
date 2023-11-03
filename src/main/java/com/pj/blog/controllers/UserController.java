package com.pj.blog.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.pj.blog.dtos.ApiResponse;
import com.pj.blog.dtos.UserDto;
import com.pj.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	create user

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createdUserDto=this.userService.createUser(userDto);
		
//		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
		return new ResponseEntity(new ApiResponse("created succesfully",true),HttpStatus.OK);
	}
	
	
//	update user
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable ("userId") Integer uId)
	{
		UserDto updatedUser=this.userService.updateUser(userDto, uId);
//		return ResponseEntity.ok(updatedUser);
		return new ResponseEntity(new ApiResponse("Updated succesfully",true),HttpStatus.OK);
	}
	
	
//	delete user
	@DeleteMapping("/{uId}")
	public ResponseEntity<ApiResponse> deleteuser(@PathVariable Integer uId)
	{
		this.userService.deleteUser(uId);
		return new ResponseEntity(new ApiResponse("deleted succesfully",true),HttpStatus.OK);
	}
	
//	get user
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		
		
		return ResponseEntity.ok(this.userService.getAllUsers());
		
	}
	
	
	@GetMapping("/{uId}")
	public ResponseEntity<UserDto> getUsers(@PathVariable Integer uId)
	{
		
		UserDto getUser=this.userService.getUserById(uId);
		return ResponseEntity.ok(getUser);
		
	}
	
}
