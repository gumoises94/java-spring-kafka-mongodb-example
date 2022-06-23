package com.gustavosaron.transactionsapi.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavosaron.transactionsapi.dto.TransactionDTO;
import com.gustavosaron.transactionsapi.service.TransactionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class TransactionListener {
	
	private final TransactionService transactionService;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@KafkaListener(topics = "transactions")
    public void listener(ConsumerRecord<String, String> consumerRecord) throws Exception {
		TransactionDTO transaction = mapper.readValue(consumerRecord.value(), TransactionDTO.class);
		
        log.info("Received transaction of type: {}", transaction.getTransactionType());
        log.info("Transaction data: {}", mapper.writeValueAsString(transaction.getTransactionData()));
        
        transactionService.insert(transaction);
    }

}
