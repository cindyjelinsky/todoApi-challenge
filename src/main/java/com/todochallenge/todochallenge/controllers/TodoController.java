package com.todochallenge.todochallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todochallenge.todochallenge.emtities.Todo;
import com.todochallenge.todochallenge.services.TodoService;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@PostMapping
	public ResponseEntity<List<Todo>>create(@RequestBody Todo todo){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(todoService.create(todo));
	}
	
	@GetMapping
	public ResponseEntity<List<Todo>> findAll(){
		List<Todo> result = todoService.list();
		return ResponseEntity.ok(result);
	}

}
