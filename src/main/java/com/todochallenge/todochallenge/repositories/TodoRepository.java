package com.todochallenge.todochallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todochallenge.todochallenge.emtities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {

}
