package com.spring.appel.model.dto.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductDTO {
	
	private String name;
	private String fornecedor;
	private Float price;

}
