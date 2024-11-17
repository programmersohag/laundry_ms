package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.dto.TransactionDto;
import com.sohag.laundry_backend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionDto doSave(TransactionDto dto) {
        return null;
    }
}
