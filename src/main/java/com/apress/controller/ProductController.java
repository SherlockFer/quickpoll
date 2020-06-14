package com.apress.controller;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apress.dto.ProductDTO;
import com.apress.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping()
	public ResponseEntity<Collection<ProductDTO>> getAllProducts() {
		Collection<ProductDTO> productDTOs = productService.findAll();
		return new ResponseEntity<>(productDTOs, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
		Optional<ProductDTO> productDTO = productService.findById(id);
		if (!productDTO.isPresent()) {
			return new ResponseEntity<>(productDTO.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(productDTO.get(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Void> create(@RequestBody ProductDTO productDTO) {
		productDTO = productService.save(productDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(buildLocationUri(productDTO.getId()));
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	private URI buildLocationUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody ProductDTO productDTO, @PathVariable Long id) {
		if (!productService.findById(id).isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		productDTO.setId(id);
		productService.save(productDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (!productService.findById(id).isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		productService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}