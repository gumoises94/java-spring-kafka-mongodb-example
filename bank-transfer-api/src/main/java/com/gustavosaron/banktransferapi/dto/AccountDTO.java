package com.gustavosaron.banktransferapi.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

	@NotBlank(message = "bank must not be empty")
	private String bank;
	@NotBlank(message = "branch must not be empty")
	private String branch;
	@NotBlank(message = "account must not be empty")
	private String account;
	
}
