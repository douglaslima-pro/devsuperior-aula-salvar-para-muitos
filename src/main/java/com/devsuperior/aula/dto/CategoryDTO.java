package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Category;

public record CategoryDTO(Long id, String name) {
	
	public CategoryDTO(Category category) {
		this(category.getId(), category.getName());
	}
	
	public Category toEntity() {
		return new Category(id, name);
	}

}
