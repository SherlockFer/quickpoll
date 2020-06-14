package com.apress.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.domain.Product;
import com.apress.dto.ProductDTO;
import com.apress.repository.ProductRepository;
import com.apress.service.mappers.ProductMapper;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductMapper productMapper;

	public Collection<ProductDTO> findAll() {
		Collection<Product> products = productRepository.findAll();
		return productMapper.toProductDTOs(products);
	}

}
