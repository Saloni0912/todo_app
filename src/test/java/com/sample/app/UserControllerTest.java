package com.sample.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.app.controller.UserController;
import com.sample.app.entity.TodoUser;
import com.sample.app.service.UserService;

@WebMvcTest(UserController.class)
class UserControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	UserService userService;
	
	TodoUser user_1 = new TodoUser(1,"Sal","Dublin");
	TodoUser user_2 = new TodoUser(2,"Pal","Galway");

	@Test
	 void getAllUsers() throws Exception {
		List<TodoUser> users = new ArrayList<>(Arrays.asList(user_1,user_2)); 
		Mockito.when(userService.getUsers()).thenReturn(users);
		
		mockMvc.perform(
		 get("/users")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(2)));
		
	}

}
