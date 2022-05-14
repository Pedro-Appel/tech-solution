package com.spring.appel.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.spring.appel.model.Product;
import com.spring.appel.model.dto.product.CreateProductDTO;
import com.spring.appel.model.dto.product.ProductResponseDTO;
import com.spring.appel.repository.ProductRepository;
import com.spring.appel.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public ProductResponseDTO createProduct(CreateProductDTO request) {

		ProductResponseDTO response = new ProductResponseDTO();
		Product product = new Product();
		
		product.setFornecedor(request.getFornecedor());
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		
		try {
			
			product = repo.saveAndFlush(product);
			
			response.setMessage("product criado com sucesso");
			response.setRetCode(200);
		} catch (Exception e) {
			response.setMessage("Erro ao criar usuario");
			response.setRetCode(500);
		}
		return response;
	}

	@Override
	public ProductResponseDTO getProduct(String id) {
		
		ProductResponseDTO response = new ProductResponseDTO();
		Product product = new Product();
		
		try {
			product = repo.findById(UUID.fromString(id)).get();

			response.setMessage("product encontrado com sucesso");
			response.setRetCode(200);
			
			response.setFornecedor(product.getFornecedor());
			response.setNome(product.getName());
			response.setValor(product.getPrice());

		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setRetCode(400);
		}

		return response;

	}

	@Override
	public Page<Product> listProducts(Pageable paginacao) {
		return repo.findAllProducts(paginacao);
	}

	@Override
	public ProductResponseDTO updateProduct(String uid, CreateProductDTO request) {
		ProductResponseDTO response = new ProductResponseDTO();
		Product product = new Product();
		try {
			product = repo.findById(UUID.fromString(uid)).get();

			if(request.getName() != null)
				product.setName(request.getName());
			if(request.getFornecedor() != null)
				product.setFornecedor(request.getFornecedor());
			if(request.getPrice() != null)
				product.setPrice(request.getPrice());
			
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setRetCode(400);
		}

		try {
			repo.save(product);
			response.setMessage("Product atualizado com sucesso");
			response.setRetCode(200);

		} catch (Exception e) {

			response.setMessage(e.getMessage());
			response.setRetCode(500);
		}
		return response;
	}

	@Override
	public ProductResponseDTO deleteProduct(String id) {
		ProductResponseDTO response = new ProductResponseDTO();
		Product product = new Product();

		try {
			product = repo.findById(UUID.fromString(id)).get();

			try {
				repo.delete(product);
				response.setMessage("Product deletado com sucesso");
				response.setRetCode(200);
				
			} catch (Exception e) {
				
				response.setMessage("falha ao deletar o Product");
				response.setRetCode(500);
			}
		} catch (IllegalArgumentException e) {
			response.setMessage("Id não pode ser nulo");
			response.setRetCode(400);
		}
		return response;
	}
}
