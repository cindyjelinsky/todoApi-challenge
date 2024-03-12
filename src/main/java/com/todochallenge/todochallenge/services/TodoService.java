package com.todochallenge.todochallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todochallenge.todochallenge.emtities.Todo;
import com.todochallenge.todochallenge.repositories.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	
	public List<Todo> list(){
		return todoRepository.findAll();
	}
	
	public List<Todo> create(Todo todo){
		todoRepository.save(todo);
		return list();
	}
	
	
	
	
	
}
