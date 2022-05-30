package com.sample.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.app.entity.TodoTask;

public interface TaskRepository extends JpaRepository<TodoTask, Integer> {

}
