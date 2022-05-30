package com.sample.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.app.dao.UserRepository;
import com.sample.app.entity.TodoUser;

import javassist.NotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public TodoUser createUser(TodoUser user) {
		return userRepository.save(user);
	}
	
	public List<TodoUser> createUsers(List<TodoUser> users){
		return userRepository.saveAll(users);
	}
	
	public TodoUser getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public List<TodoUser> getUsers(){
		return userRepository.findAll();
	}
	
	public TodoUser updateUser(TodoUser user) throws NotFoundException {
		TodoUser oldUser = null;
		Optional<TodoUser> optionalUser = userRepository.findById(user.getId());
		if(optionalUser.isPresent()) {
			oldUser = optionalUser.get();
			oldUser.setName(user.getName());
			oldUser.setAddress(user.getAddress());
			userRepository.save(oldUser);
		}
		else {
			throw new NotFoundException("User with ID" + user.getId() + " does not exist");
		}
		return oldUser;
	}
	
	public String deleteUserById(int id) throws NotFoundException {
		Optional<TodoUser> optionalUser = userRepository.findById(id);
		if (!optionalUser.isPresent()) {
	        throw new NotFoundException("User with ID " + id + " does not exist.");
	    }
		userRepository.deleteById(id);
		return "User got deleted !";
	}

}
