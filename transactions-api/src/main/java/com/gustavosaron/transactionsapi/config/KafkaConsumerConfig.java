package com.gustavosaron.transactionsapi.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class KafkaConsumerConfig {
	
	private final KafkaProperties kafkaProperties;

	@Bean
	ConsumerFactory<String, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties(), 
				new StringDeserializer(), new StringDeserializer());
	}

	@Bean
	ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory
		= new ConcurrentKafkaListenerContainerFactory<String, String>();
		concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory());

		return concurrentKafkaListenerContainerFactory;
	}

}