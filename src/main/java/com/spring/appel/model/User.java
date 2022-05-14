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
@Table(name = "users")
public class User {
	
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(name = "uid",length = 36, nullable = false, updatable = false)
	private UUID uid;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(name = "password",nullable = false)
	private String password;
	
}
