package com.gustavosaron.transactionsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
	private String transactionType;
	private Object transactionData;
}
