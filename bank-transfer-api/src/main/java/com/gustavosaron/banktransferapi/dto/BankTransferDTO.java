package com.gustavosaron.banktransferapi.dto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankTransferDTO {
	@Min(value = 1, message = "transferValue should not be less than 1")
	private double transferValue;
	@Valid
	@NotNull(message = "originAccount must not be null")
	private AccountDTO originAccount;
	@Valid
	@NotNull(message = "destinationAccount must not be null")
	private AccountDTO destinationAccount;
}
