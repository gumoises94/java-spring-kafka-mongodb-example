package com.gustavosaron.banktransferapi.service.impl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.gustavosaron.banktransferapi.config.KafkaProducerConfig;
import com.gustavosaron.banktransferapi.dto.BankTransferDTO;
import com.gustavosaron.banktransferapi.dto.TransactionDTO;
import com.gustavosaron.banktransferapi.service.BankTransferService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BankTransferServiceImpl implements BankTransferService {
	
	private static final String TRANSACTION_TYPE_TRANSFER = "TRANSFER";
	
	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	@Override
	public void transfer(BankTransferDTO bankTransfer) {
		TransactionDTO transaction = TransactionDTO.builder()
				.transactionType(TRANSACTION_TYPE_TRANSFER)
				.transactionData(bankTransfer)
				.build();
		
		this.kafkaTemplate.send(KafkaProducerConfig.TRANSACTIONS_TOPIC, transaction);
	}

}
