package com.spring.appel.model.dto.user;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO{
	
	@NotEmpty private String username;
	@NotEmpty private String password;
	
}
