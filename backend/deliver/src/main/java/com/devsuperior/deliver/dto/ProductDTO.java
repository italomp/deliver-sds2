package com.devsuperior.deliver.dto;

import com.devsuperior.deliver.entities.Product;
import java.io.Serializable;

public class ProductDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private float price; 
	private String description;
	private String imageUri;
	
	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, float price, String description, String imageUri) {
		super();
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setDescription(description);
		this.setImageUri(imageUri);
	}
	
	public ProductDTO(Product entity) {
		super();
		setId(entity.getId());
		setName(entity.getName());
		setPrice(entity.getPrice());
		setDescription(entity.getDescription());
		setImageUri(entity.getImageUri());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	
	
}
