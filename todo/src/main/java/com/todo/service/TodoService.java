package com.todo.service;

import com.todo.entity.Todo;
import com.todo.exception.BusinessLogicException;
import com.todo.exception.ExceptionCode;
import com.todo.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
	private final TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public Todo createTodo(Todo todo) {
		return todoRepository.save(todo);
	};

	public Todo updateTodo(Todo todo) {
		Todo findTodo = findTodo(todo.getTodoId());

		findTodo.setTitle(todo.getTitle());
		findTodo.setTodoOrder(todo.getTodoOrder());
		findTodo.setCompleted(todo.isCompleted());

		return todoRepository.save(findTodo);
	}
	public Todo findTodo(long todoId) {
		Todo todo = todoRepository.findById(todoId)
						.orElseThrow(() -> new BusinessLogicException(ExceptionCode.TODO_NOT_FOUND));
		return todo;
	}

	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	public void deleteTodo(long todoId) {
		Todo todo = todoRepository.findById(todoId)
						.orElseThrow(() -> new BusinessLogicException(ExceptionCode.TODO_NOT_FOUND));
		todoRepository.delete(todo);
	}

	public void deleteTodos() {

	}
}
