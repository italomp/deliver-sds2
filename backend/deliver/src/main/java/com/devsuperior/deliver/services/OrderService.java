package com.devsuperior.deliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.deliver.dto.OrderDTO;
import com.devsuperior.deliver.entities.Order;
import com.devsuperior.deliver.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true) //optional annotation to become speed code
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());
	}

}
