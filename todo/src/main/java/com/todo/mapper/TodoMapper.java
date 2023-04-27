package com.todo.mapper;

import com.todo.dto.TodoDto;
import com.todo.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TodoMapper {
	Todo todoPostDtoToTodo(TodoDto.Post todoPostDto);
	Todo todoPatchDtoToTodo(TodoDto.Patch todoPatchDto);
	TodoDto.TodoResponse todoToTodoResponseDto(Todo todo);

	List<TodoDto.TodoResponse> todosToTodoResponseDtos(List<Todo> todos);

}
