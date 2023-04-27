package com.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class TodoDto {
	@Getter
	@NoArgsConstructor
	public static class Post{
		@NotBlank
		private String title;
		@NotBlank
		private int todoOrder;
		@NotBlank
		private boolean completed;
	}

	@Getter
	@Setter
	@NoArgsConstructor
	public static class Patch{
		private long todoId;
		private String title;
		private int todoOrder;
		private	boolean completed;
	}

	@Getter
	@Setter
	@NoArgsConstructor
	public static class Get {
		private long todoId;
		private String title;
		private int todoOrder;
		private	boolean completed;
	}

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class TodoResponse {
		private long todoId;
		private String title;
		private int todoOrder;
		private	boolean completed;
	}
}
