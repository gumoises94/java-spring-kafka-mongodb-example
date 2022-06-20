package com.gustavosaron.transactionsapi.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavosaron.transactionsapi.dto.TransactionDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionListener {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@KafkaListener(topics = "transactions")
    public void listener(ConsumerRecord<String, String> consumerRecord) throws Exception {
		TransactionDTO transaction = mapper.readValue(consumerRecord.value(), TransactionDTO.class);
		
        log.info("Received transaction of type: {}", transaction.getTransactionType());
        log.info("Transaction data: {}", mapper.writeValueAsString(transaction.getTransactionData()));
    }

}
