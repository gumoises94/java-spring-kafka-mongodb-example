package com.gustavosaron.transactionsapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavosaron.transactionsapi.dto.TransactionDTO;
import com.gustavosaron.transactionsapi.entity.TransactionEntity;
import com.gustavosaron.transactionsapi.repository.TransactionRepository;
import com.gustavosaron.transactionsapi.service.TransactionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

	private final TransactionRepository transactionRepository;

	@Override
	public void insert(TransactionDTO transactionDTO) {
		TransactionEntity transactionEntity = TransactionEntity.builder()
				.transactionType(transactionDTO.getTransactionType())
				.transactionData(transactionDTO.getTransactionData())
				.build();

		transactionRepository.insert(transactionEntity);
	}

	@Override
	public List<TransactionDTO> getAll() {
		List<TransactionDTO> transactions = new ArrayList<>();

		transactionRepository.findAll()
		.forEach(entity -> {
			TransactionDTO dto = TransactionDTO.builder()
					.transactionType(entity.getTransactionType())
					.transactionData(entity.getTransactionData())
					.build();
			transactions.add(dto);
		});
		
		return transactions;
	}

}
