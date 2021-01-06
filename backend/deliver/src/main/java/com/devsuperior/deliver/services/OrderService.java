package com.devsuperior.deliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.deliver.dto.OrderDTO;
import com.devsuperior.deliver.dto.ProductDTO;
import com.devsuperior.deliver.entities.Order;
import com.devsuperior.deliver.entities.OrderStatus;
import com.devsuperior.deliver.entities.Product;
import com.devsuperior.deliver.repositories.OrderRepository;
import com.devsuperior.deliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	//optional annotation to become speed code
	@Transactional(readOnly = true) 
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());
	}

	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
				Instant.now(), OrderStatus.PENDING);
		for(ProductDTO p : dto.getProducts()) {
			//getOne build product instance without go to database
			Product product = this.productRepository.getOne(p.getId()); 
			order.getProducts().add(product);
		}
		order = this.repository.save(order);
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = this.repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = this.repository.save(order);
		return new OrderDTO(order);
	}
}
