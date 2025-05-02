package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.dto.ProductionDto;
import com.sohag.laundry_backend.exception.NotFoundException;
import com.sohag.laundry_backend.model.Employee;
import com.sohag.laundry_backend.model.Production;
import com.sohag.laundry_backend.repository.ProductionRepository;
import com.sohag.laundry_backend.util.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductionService {

    private final ProductionRepository productionRepository;

    public ProductionService(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    public ProductionDto doSave(ProductionDto dto) {
        Production production = new Production();
        production.setId(System.currentTimeMillis());
        production.setEmployee(new Employee(dto.getEmployeeId()));
        production.setTotal(dto.getTotal());
        production.setDetails(dto.getDetails());
        production.setDateOfIssue(dto.getDateOfIssue());
        productionRepository.save(production);
        return dto;
    }

    public ProductionDto doUpdate(ProductionDto dto) throws NotFoundException {
        Production production = productionRepository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("Expense does not exist"));
        production.setEmployee(new Employee(dto.getEmployeeId()));
        production.setTotal(dto.getTotal());
        production.setDetails(dto.getDetails());
        production.setDateOfIssue(dto.getDateOfIssue());
        productionRepository.save(production);
        return dto;
    }

    public ProductionDto paySalary(ProductionDto dto) {
        Production production = new Production();
        production.setId(System.currentTimeMillis());
        production.setEmployee(new Employee(dto.getEmployeeId()));
        production.setTotal(dto.getTotal());
        production.setDetails("Employee Salary Payment for the month of " + DateUtil.getLastMnyr());
        production.setDateOfIssue(new Date());
        productionRepository.save(production);
        return dto;
    }

    public List<ProductionDto> findAll() {
        return productionRepository.findAllExpenditure();
    }

    public List<ProductionDto> findAllByDateRange(Date from, Date to) {
        return productionRepository.findAllByDateBetween(from, to);
    }

    public void removeById(Long expId) throws NotFoundException {
        Production production = productionRepository.findById(expId).orElseThrow(() -> new NotFoundException("Expense does not exist"));
        productionRepository.delete(production);
    }

    public Double totalExpense(Date from, Date to) {
        return productionRepository.findTotalExpenseThisYear(from, to);
    }
}
