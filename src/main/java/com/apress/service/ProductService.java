package com.apress.service;

import java.util.Collection;
import java.util.Optional;

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

	public Optional<ProductDTO> findById(long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return Optional.of(productMapper.toProductDTO(product.get()));
		}
		return Optional.empty();
	}

	public ProductDTO save(ProductDTO productDTO) {
		Product product = productRepository.save(productMapper.toProduct(productDTO));
		return productMapper.toProductDTO(product);
	}

	public void deleteById(Long productId) {
		productRepository.deleteById(productId);
	}

}
