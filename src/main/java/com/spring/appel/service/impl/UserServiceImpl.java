package com.spring.appel.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.appel.model.User;
import com.spring.appel.model.dto.BaseResponseDTO;
import com.spring.appel.model.dto.user.CreateUserDTO;
import com.spring.appel.model.dto.user.UserResponseDTO;
import com.spring.appel.repository.UserRepository;
import com.spring.appel.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	public UserResponseDTO createUser(CreateUserDTO request) {

		UserResponseDTO response = new UserResponseDTO();
		User user = new User();

		user.setPassword(request.getPassword());
		user.setName(request.getUsername());
		try {
			user = repo.saveAndFlush(user);
			response.setUid(user.getUid().toString());
			response.setMessage("Usuario criado com sucesso");
			response.setRetCode(10000);
		} catch (Exception e) {
			response.setMessage("Erro ao criar usuario");
			response.setRetCode(5000);
		}
		return response;
	}

	
	@Override
	public BaseResponseDTO signIn(CreateUserDTO request) {

		BaseResponseDTO response = new BaseResponseDTO();
		User user = repo.findByName(request.getUsername());
		
		if(user.getPassword().equals(request.getPassword())) response.setRetCode(200);
		
		else response.setRetCode(401);
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	public UserResponseDTO getUser(String id) {

		UserResponseDTO response = new UserResponseDTO();
		User user = new User();
		try {
			user = repo.findById(UUID.fromString(id)).get();

			response.setMessage("Usuario encontrado com sucesso");
			response.setRetCode(10000);
			response.setName(user.getName());
			response.setUid(id.toString());

		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setRetCode(40000);
		}

		return response;

	}

	public Iterable<User> listUsers() {

		return repo.findAll();

	}

	public UserResponseDTO updateUser(String uid, CreateUserDTO request) {
		UserResponseDTO response = new UserResponseDTO();
		User user = new User();

		try {
			user = repo.findById(UUID.fromString(uid)).get();

			if (request.getUsername() != null)
				user.setName(request.getUsername());
			if (request.getPassword() != null)
				user.setPassword(request.getPassword());
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setRetCode(40000);
		}

		try {
			repo.save(user);
			response.setMessage("Usuario atualizado com sucesso");
			response.setRetCode(10000);

		} catch (Exception e) {

			response.setMessage(e.getMessage());
			response.setRetCode(50000);
		}
		return response;

	}

	@Override
	public UserResponseDTO deleteUser(String id) {

		UserResponseDTO response = new UserResponseDTO();
		User user = new User();

		try {
			user = repo.findById(UUID.fromString(id)).get();

			try {
				repo.delete(user);
				response.setMessage("Usuario deletado com sucesso");
				response.setRetCode(10000);
				
			} catch (Exception e) {
				
				response.setMessage("falha ao deletar o usuario");
				response.setRetCode(50000);
			}
		} catch (IllegalArgumentException e) {
			response.setMessage("Id não pode ser nulo");
			response.setRetCode(40000);
		}
		return response;

	}
}
