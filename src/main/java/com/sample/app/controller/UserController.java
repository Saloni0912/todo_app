package com.sample.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.app.entity.TodoUser;
import com.sample.app.exception.InvalidRequestException;
import com.sample.app.service.UserService;

import javassist.NotFoundException;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addUser")
	public TodoUser addUser(@RequestBody TodoUser user) {
		return userService.createUser(user);
	}

	@PostMapping("/addUsers")
	public List<TodoUser> addUsers(@RequestBody List<TodoUser> users){
		return userService.createUsers(users);
		
	}
	
	@GetMapping("/user/{id}")
	public TodoUser getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/users")
	public List<TodoUser> getAllUsers(){
		return userService.getUsers();
	}
	
	@PutMapping("/updateuser")
	public TodoUser updateUser(@RequestBody TodoUser user) throws NotFoundException {
		if (user == null || user.getId() == 0) {
	        throw new InvalidRequestException("User must not be null!");
	    }
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) throws NotFoundException {
		return userService.deleteUserById(id);
	}
}
