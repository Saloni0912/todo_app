package com.sample.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.app.dao.TaskRepository;
import com.sample.app.entity.TodoTask;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskrepository;
	
	public TodoTask addTask(TodoTask task) {
		return taskrepository.save(task);
	}
	
	public List<TodoTask> addTasks(List<TodoTask> tasks){
		return taskrepository.saveAll(tasks);
	}
	
	public List<TodoTask> viewTasks(){
		return taskrepository.findAll();
	}
	
	public TodoTask viewTaskById(int id) {
		return taskrepository.findById(id).orElse(null);
	}
	
	public TodoTask updateTask(TodoTask task) {
		TodoTask oldTask = null;
		Optional<TodoTask> optionalUser = taskrepository.findById(task.getId());
		if(optionalUser.isPresent()) {
			oldTask = optionalUser.get();
			oldTask.setDesc(task.getDesc());
			oldTask.setDate(task.getDate());
			oldTask.setStatus(task.isStatus());
			taskrepository.save(oldTask);
		}
		else {
			return new TodoTask();
		}
		return oldTask;
	}
	
	public String deleteTaskById(int id) {
		taskrepository.deleteById(id);
		return "Task is deleted";
	}

}
