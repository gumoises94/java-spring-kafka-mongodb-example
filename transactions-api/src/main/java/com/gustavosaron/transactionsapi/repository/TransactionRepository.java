package com.gustavosaron.transactionsapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gustavosaron.transactionsapi.entity.TransactionEntity;

public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {

}
