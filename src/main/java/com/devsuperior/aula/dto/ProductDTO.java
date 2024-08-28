package com.devsuperior.aula.dto;

import java.util.List;

import com.devsuperior.aula.entities.Product;

public record ProductDTO(Long id, String name, Double price, List<CategoryDTO> categories) {

	public ProductDTO(Product product) {
		this(product.getId(), product.getName(), product.getPrice(), product.getCategories()
				.stream()
				.map(category -> new CategoryDTO(category))
				.toList());
	}
	
	public Product toEntity() {
		Product product = new Product(id, name, price);
		categories.forEach(categoryDTO -> {
			product.getCategories().add(categoryDTO.toEntity());
		});
		return product;
	}
	
}
