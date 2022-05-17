package com.spring.appel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.appel.model.dto.TokenDTO;
import com.spring.appel.model.dto.user.CreateUserDTO;
import com.spring.appel.service.impl.TokenService;

import lombok.extern.log4j.Log4j2;


@Log4j2
@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid CreateUserDTO person) {
		log.info("authenticating...");
		UsernamePasswordAuthenticationToken dadosLogin = 
				new UsernamePasswordAuthenticationToken(person.getUsername(), person.getPassword());
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			log.info("success token");
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
		} catch (AuthenticationException e) {
			log.info("failed token");
			return ResponseEntity.badRequest().build();
		}
	}
}
