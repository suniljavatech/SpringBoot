package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.ProductRepository;
import com.shop.model.Product;
@Service
public class ProductService {
@Autowired
ProductRepository productRepository;
	
	public void saveProduct(Product product) {
	productRepository.save(product);
	
}
}
