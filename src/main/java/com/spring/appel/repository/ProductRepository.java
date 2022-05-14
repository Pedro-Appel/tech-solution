package com.spring.appel.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.appel.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>  {

	@Query("SELECT vd FROM Product vd")
	Page<Product> findAllProducts(Pageable paginacao);

}
