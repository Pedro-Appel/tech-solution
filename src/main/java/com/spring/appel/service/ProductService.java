package com.spring.appel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.appel.model.Product;
import com.spring.appel.model.dto.product.CreateProductDTO;
import com.spring.appel.model.dto.product.ProductResponseDTO;

@Service
public interface ProductService {
	
	public ProductResponseDTO createProduct(CreateProductDTO request);
	public ProductResponseDTO getProduct(String id);
	public Page<Product> listProducts(Pageable paginacao);
	public ProductResponseDTO updateProduct(String uid, CreateProductDTO request);
	public ProductResponseDTO deleteProduct(String id);

}
