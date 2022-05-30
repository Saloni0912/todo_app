package com.sample.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.app.entity.TodoUser;

public interface UserRepository extends JpaRepository<TodoUser, Integer> {

}
