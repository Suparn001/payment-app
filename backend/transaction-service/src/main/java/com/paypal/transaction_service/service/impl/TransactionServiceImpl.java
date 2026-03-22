package com.paypal.transaction_service.service.impl;

import com.paypal.transaction_service.entity.Transaction;
import com.paypal.transaction_service.repository.TransactionRepository;
import com.paypal.transaction_service.service.TransactionService;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.Instant;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    private final ObjectMapper objectMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, ObjectMapper objectMapper) {
        this.transactionRepository = transactionRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Transaction createTransaction(Transaction request) {
        System.out.println("Creating Transaction");
        Transaction transaction = new Transaction();
        transaction.setSenderId(request.getSenderId());
        transaction.setReceiverId(request.getReceiverId());
        transaction.setTimeStamp(Instant.now());
        transaction.setStatus("SUCCESS");
        transaction.setAmount(request.getAmount());
        System.out.println("Incoming transaction object:" + objectMapper.writeValueAsString(request));
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return null;
    }
}
