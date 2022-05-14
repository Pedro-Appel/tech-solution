package com.spring.appel.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(value = Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = false)
public class BaseResponseDTO {
	
	private Integer retCode;
	private String message;
}
