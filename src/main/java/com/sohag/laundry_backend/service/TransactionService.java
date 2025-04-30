package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.dto.TransactionDto;
import com.sohag.laundry_backend.exception.NotFoundException;
import com.sohag.laundry_backend.model.Transaction;
import com.sohag.laundry_backend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public List<Transaction> findAllByDateRange(Date startDate, Date endDate) {
        return transactionRepository.findAllByDateBetween(startDate, endDate);
    }

    public Transaction findById(String trxId) throws NotFoundException {
        return transactionRepository.findById(trxId).orElseThrow(() -> new NotFoundException("Order Not Found!!!"));
    }

    public Transaction doSave(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setCustomerId(dto.getCustomerId());
        transaction.setEmployeeId(dto.getEmployeeId());
        transaction.setTotal(dto.getTotal());
        transaction.setWeight(dto.getWeight());
        transaction.setDateOfOrder(new Date());
        return transactionRepository.save(transaction);
    }

    public Transaction update(TransactionDto dto) throws NotFoundException {
        Transaction transaction = findById(dto.getTrxId());
        transaction.setCustomerId(dto.getCustomerId());
        transaction.setEmployeeId(dto.getEmployeeId());
        transaction.setTotal(dto.getTotal());
        transaction.setWeight(dto.getWeight());
        return transactionRepository.save(transaction);
    }

    public Transaction update(String trxId) throws NotFoundException {
        Transaction transaction = findById(trxId);
        transaction.setDateOfDelivery(new Date());
        return transactionRepository.save(transaction);
    }
}
