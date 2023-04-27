package com.todo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class MultiResponseDto<T> {
	private List<T> data; // 1 페이지에 대한 모든 질문이 들어가있는 데이터
	private PageInfo pageInfo; // 페이션네이션 정보 1,2,3,4,5

	public MultiResponseDto(List<T> data, Page page) {
		this.data = data;
		this.pageInfo = new PageInfo(page.getNumber() + 1,
						page.getSize(), page.getTotalElements(), page.getTotalPages());
	}

	@Getter
	@AllArgsConstructor
	public class PageInfo {
		private Integer page;
		private Integer size; // 한 페이지당 사이즈가 몇인지
		private Long totalElements; // 총 객체수
		private Integer totalPages; // 총 몇페이지
	}
}
