package com.crud.api.service;

import java.util.List;

import com.crud.api.model.Product;

public interface IProductService {
	List<Product> getProducts();
	Product addProduct(Product product);
	Product updateProduct(Product product, Long id);
	void deleteProduct(Long id);
	Product getProductById(Long id);
	
}
