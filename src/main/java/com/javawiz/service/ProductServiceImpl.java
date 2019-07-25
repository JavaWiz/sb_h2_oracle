package com.javawiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawiz.entity.Product;
import com.javawiz.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}
}