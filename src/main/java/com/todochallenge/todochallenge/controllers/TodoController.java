package com.todochallenge.todochallenge.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todochallenge.todochallenge.emtities.Todo;
import com.todochallenge.todochallenge.services.TodoService;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@PostMapping
	public ResponseEntity<Todo>create(@RequestBody Todo todo){
		this.todoService.create(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest() //caminho para qual a Task vai
				 .path("/{id}").buildAndExpand(todo.getId()).toUri();
		 return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public List<Todo> findAll(){
		return this.todoService.list();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Long id){
		Todo obj = this.todoService.findById(id);
		return ResponseEntity.ok().body(obj);
	
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> update( @PathVariable Long id, @RequestBody Todo todo){
		todo.setId(id);
		this.todoService.update(todo);
		return ResponseEntity.noContent().build();
		
	}
	
	
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable Long id){
		 todoService.delete(id);			
	}

}
