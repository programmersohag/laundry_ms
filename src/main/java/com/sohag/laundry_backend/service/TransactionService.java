package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.dto.OrderDto;
import com.sohag.laundry_backend.exception.NotFoundException;
import com.sohag.laundry_backend.model.Customer;
import com.sohag.laundry_backend.model.Employee;
import com.sohag.laundry_backend.model.Transaction;
import com.sohag.laundry_backend.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<OrderDto> findAll() {
        return transactionRepository.findAllOrder();
    }

    public List<OrderDto> findAllByDateRange(Date startDate, Date endDate) {
        return transactionRepository.findAllByDateBetween(startDate, endDate);
    }

    public OrderDto findOneById(String trxId) throws NotFoundException {
        OrderDto trx = transactionRepository.findOneOrder(trxId).orElseThrow(() -> new NotFoundException("Order Not Found!!!"));
        trx.setTotal(trx.getWeight() * 30);
        return trx;
    }

    public Transaction findById(String trxId) throws NotFoundException {
        return transactionRepository.findById(trxId).orElseThrow(() -> new NotFoundException("Order Not Found!!!"));
    }

    @Transactional
    public Transaction doSave(OrderDto dto) {
        Transaction transaction = new Transaction();
        transaction.setId(System.currentTimeMillis() + "");
        transaction.setCustomer(new Customer(dto.getCustomerId()));
        transaction.setEmployee(new Employee(dto.getEmployeeId()));
        transaction.setTotal(dto.getWeight() * 30);
        transaction.setWeight(dto.getWeight());
        transaction.setDateOfOrder(new Date());
        return transactionRepository.save(transaction);
    }

    public Transaction update(OrderDto dto) throws NotFoundException {
        Transaction transaction = findById(dto.getTrxId());
        transaction.setCustomer(new Customer(dto.getCustomerId()));
        transaction.setEmployee(new Employee(dto.getEmployeeId()));
        transaction.setTotal(dto.getWeight() * 30);
        transaction.setWeight(dto.getWeight());
        return transactionRepository.save(transaction);
    }

    public Transaction update(String trxId) throws NotFoundException {
        Transaction transaction = findById(trxId);
        transaction.setDateOfDelivery(new Date());
        return transactionRepository.save(transaction);
    }

    public long countAllActiveIncome() {
        return transactionRepository.countByDateOfDeliveryIsNotNull();
    }

    public long countAllInactiveIncome() {
        return transactionRepository.countByDateOfDeliveryIsNull();
    }

    public Double totalIncome(Date startDate, Date endDate) {
        return transactionRepository.findTotalTrxThisYear(startDate, endDate);
    }
}
