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

import com.sample.app.entity.TodoTask;
import com.sample.app.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/addTask")
	public TodoTask addTask(@RequestBody TodoTask task) {
		return taskService.addTask(task);
	}
	
	@PostMapping("/addTasks")
	public List<TodoTask> addTasks(@RequestBody List<TodoTask> tasks){
		return taskService.addTasks(tasks);
		
	}
	
	@GetMapping("/getTask/{id}")
	public TodoTask getTaskById(@PathVariable int id) {
		return taskService.viewTaskById(id);
	}
	
	@GetMapping("/getTasks")
	public List<TodoTask> getTasks(){
		return taskService.viewTasks();
	}
	
	@PutMapping("/editTask")
	public TodoTask updateTask(@RequestBody TodoTask task) {
		return taskService.updateTask(task);
	}
	
	@DeleteMapping("/task/{id}")
	public String deleteTask(@PathVariable int id) {
		return taskService.deleteTaskById(id);
	}

}
