package com.gustavosaron.transactionsapi.service;

import java.util.List;

import com.gustavosaron.transactionsapi.dto.TransactionDTO;

public interface TransactionService {

	void insert(TransactionDTO transactionDTO);
	List<TransactionDTO> getAll();
	
}
