package com.devsuperior.deliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.deliver.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	/**
	 * Name é uma parte dinâmica desa assinatura
	 * que referencia o atributo name de Product.
	 * 
	 * Asc quer dizer que quero ordenado em ordem
	 * ascendente. Poderia ser desc (descendente).
	 * @return
	 */
	List<Product> findAllByOrderByNameAsc();
}
