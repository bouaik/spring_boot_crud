package com.crud.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.api.model.Product;
import com.crud.api.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductService {
	
	private final ProductRepository productRepository;
	
	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product, Long id) {
		return productRepository.findById(id)
				.map(oldProduct -> {
					oldProduct.setName(product.getName());
					oldProduct.setDescription(product.getDescription());
					oldProduct.setPrice(product.getPrice());
					return productRepository.save(oldProduct);
				}).orElseThrow(() -> new RuntimeException("Product not found woth id " + id));
				}

	@Override
	public void deleteProduct(Long id) {
		if(productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
		}
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	
	//@PostConstruct
	//public List<Product> saveProducts() {
	//	return productRepository.saveAll(Arrays.asList(new Product(3L, "coca", 23, "hello")));
	//}
	
}
    