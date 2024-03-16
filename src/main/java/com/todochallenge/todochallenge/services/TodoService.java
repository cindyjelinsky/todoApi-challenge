package com.todochallenge.todochallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todochallenge.todochallenge.emtities.Todo;
import com.todochallenge.todochallenge.repositories.TodoRepository;

import jakarta.transaction.Transactional;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	
	public List<Todo> list(){
		return todoRepository.findAll();
	}
	
	public Todo findById(Long id){
		Optional<Todo> todo = this.todoRepository.findById(id);
		return todo.orElseThrow(() -> new RuntimeException("Task Not found"));
	}
	
	@Transactional
	public Todo create(Todo todo){
		todoRepository.save(todo);
		return todo;
	}
	
	@Transactional
	public Todo update(Todo todo) {
		Todo newTodo = findById(todo.getId());
	    newTodo.setDescription(todo.getDescription());
	    return todoRepository.save(newTodo);
	   

	  }
		
	public void delete(Long id){
		todoRepository.deleteById(id);
	}
	
	
	
	
	
}
