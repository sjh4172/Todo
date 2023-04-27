package com.todo.controller;

import com.todo.dto.TodoDto;
import com.todo.entity.Todo;
import com.todo.mapper.TodoMapper;
import com.todo.response.MultiResponseDto;
import com.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;

@RestController
@Validated
@RequestMapping("/todo")
public class TodoController {
	private final TodoService todoService;
	private final TodoMapper mapper;

	public TodoController(TodoService todoService, TodoMapper mapper) {
		this.todoService = todoService;
		this.mapper = mapper;
	}

	@PostMapping
	public ResponseEntity postTodo (@RequestBody TodoDto.Post requestBody) {
		Todo todo = mapper.todoPostDtoToTodo(requestBody);

		Todo response = todoService.createTodo(todo);

		return new ResponseEntity(mapper.todoToTodoResponseDto(response), HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity patchTodo(@PathVariable("id") long id,
																	@Valid @RequestBody TodoDto.Patch requestBody) {
		requestBody.setTodoId(id);

		Todo todo = mapper.todoPatchDtoToTodo(requestBody);

		Todo response = todoService.updateTodo(todo);

		return new ResponseEntity(mapper.todoToTodoResponseDto(response), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity getTodo(@PathVariable("id") long id){
		Todo response = todoService.findTodo(id);

		return new ResponseEntity(mapper.todoToTodoResponseDto(response), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity getTodos() {
		return new ResponseEntity(todoService.findAll(), HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity deleteTodo(@PathVariable("id") long id) {
		todoService.deleteTodo(id);

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public void deleteTodos() {

	}

}
