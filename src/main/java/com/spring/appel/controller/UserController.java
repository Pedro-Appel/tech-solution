package com.spring.appel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.spring.appel.model.User;
import com.spring.appel.model.dto.BaseResponseDTO;
import com.spring.appel.model.dto.user.CreateUserDTO;
import com.spring.appel.model.dto.user.UserResponseDTO;
import com.spring.appel.service.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;

	@PostMapping("/signon")
	public ResponseEntity<UserResponseDTO> signOn(@RequestBody CreateUserDTO request) {
		log.info("Creating user");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:4200");

		return ResponseEntity.ok().headers(headers).body(service.createUser(request));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<BaseResponseDTO> singIn(@RequestBody CreateUserDTO request) {
		
		log.info("Authenticating user");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:4200");

		return ResponseEntity.ok().headers(headers).body(service.signIn(request));
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public UserResponseDTO getUser(@PathVariable String id) {
		log.info("Retrieving user with id: "+id);
		return service.getUser(id);
	}
	
	@GetMapping()
	public Iterable<User> listAllUser() {
		log.info("Listing users");
		return service.listUsers();
	}
	
	@PutMapping("{id}")
	public UserResponseDTO updateUser(@PathVariable String id, @RequestBody CreateUserDTO request) {
		log.info("Updating user with id: "+ id);
		return service.updateUser(id, request);
	}
	
	@DeleteMapping("{id}")
	public UserResponseDTO deleteUser(@PathVariable String id) {
		log.info("Deleting user with id"+id);
		return service.deleteUser(id);
	}
}
