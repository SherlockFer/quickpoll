package com.apress.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apress.dto.ProductDTO;
import com.apress.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/products")
	public ResponseEntity<Collection<ProductDTO>> getAllProducts() {
		Collection<ProductDTO> productDTOs = productService.findAll();
		return new ResponseEntity<>(productDTOs, HttpStatus.OK);
	}

}
