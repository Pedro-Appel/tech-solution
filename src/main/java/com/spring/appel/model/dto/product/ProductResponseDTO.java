package com.spring.appel.model.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spring.appel.model.dto.BaseResponseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class ProductResponseDTO extends BaseResponseDTO {
	
	private String fornecedor;
	private String nome;
	private Float valor;

}
