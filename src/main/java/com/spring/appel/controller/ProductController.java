package com.spring.appel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.appel.model.Product;
import com.spring.appel.model.dto.product.CreateProductDTO;
import com.spring.appel.model.dto.product.ProductResponseDTO;
import com.spring.appel.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping
	public ProductResponseDTO createProduct(@RequestBody CreateProductDTO request) {
		log.info("Creating Product");
		return service.createProduct(request);
	}

	@GetMapping()
	public ResponseEntity<Page<Product>> listAllProducts(
			@PageableDefault(direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		log.info("Listing Product");
		Page<Product> gameList = service.listProducts(paginacao);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:4200");

		return ResponseEntity.ok().headers(headers).body(gameList);
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public ProductResponseDTO getProduct(@PathVariable String id) {
		log.info("Retrieving Product with id: " + id);
		return service.getProduct(id);
	}

	@PutMapping("{id}")
	public ProductResponseDTO updateProduct(@PathVariable String id,
			@RequestBody CreateProductDTO request) {
		log.info("Updating Product with id: " + id);
		return service.updateProduct(id, request);
	}

	@DeleteMapping
	public ProductResponseDTO deleteProduct(@PathVariable String id) {
		log.info("Deleting Product with id" + id);
		return service.deleteProduct(id);
	}
}
