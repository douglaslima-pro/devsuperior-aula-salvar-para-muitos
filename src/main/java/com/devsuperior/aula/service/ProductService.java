package com.devsuperior.aula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.dto.ProductDTO;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	public ProductDTO insert(ProductDTO productDTO) {
		Product product = productDTO.toEntity();
		product.getCategories().clear();
		productDTO.categories().forEach(categoryDTO -> {
			product.getCategories().add(categoryRepository.getReferenceById(categoryDTO.id()));
		});
		productRepository.save(product);
		return new ProductDTO(product);
	}

}
