package com.spring.appel.model.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spring.appel.model.dto.BaseResponseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = Include.NON_EMPTY)
public class UserResponseDTO extends BaseResponseDTO{
	
	private String uid;
	private String name;
	private String email;

}
