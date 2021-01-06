package com.devsuperior.deliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.deliver.dto.ProductDTO;
import com.devsuperior.deliver.entities.Product;
import com.devsuperior.deliver.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true) //optional annotation to become speed code
	public List<ProductDTO> findAll(){
		List<Product> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
	}

}
