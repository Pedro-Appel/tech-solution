package com.spring.appel.service;

import org.springframework.stereotype.Service;

import com.spring.appel.model.User;
import com.spring.appel.model.dto.BaseResponseDTO;
import com.spring.appel.model.dto.user.CreateUserDTO;
import com.spring.appel.model.dto.user.UserResponseDTO;

@Service
public interface UserService {
	
	public UserResponseDTO createUser(CreateUserDTO request);
	public BaseResponseDTO signIn(CreateUserDTO request);
	public UserResponseDTO getUser(String id);
	public Iterable<User> listUsers();
	public UserResponseDTO updateUser(String uid, CreateUserDTO request);
	public UserResponseDTO deleteUser(String id);

}
