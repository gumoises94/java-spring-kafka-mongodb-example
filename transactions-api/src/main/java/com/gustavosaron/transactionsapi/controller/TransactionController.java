package com.gustavosaron.transactionsapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavosaron.transactionsapi.dto.TransactionDTO;
import com.gustavosaron.transactionsapi.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
	
	private final TransactionService transactionService;
	
	@GetMapping
	public List<TransactionDTO> getAllTransactions() {
		return transactionService.getAll();
	}

}
