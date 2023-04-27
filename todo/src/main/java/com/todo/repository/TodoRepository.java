package com.todo.repository;
import com.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TodoRepository extends JpaRepository<Todo, Long>{
}
