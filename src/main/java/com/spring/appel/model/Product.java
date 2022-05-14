package com.spring.appel.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(name = "uid ",length = 36, nullable = false, updatable = false)
	private UUID id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "fornecedor")
	private String fornecedor;	
	
	@Column(name = "price")
	private Float price;
}
