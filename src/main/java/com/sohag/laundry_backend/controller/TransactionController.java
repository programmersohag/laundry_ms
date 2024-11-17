package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.EmployeeDto;
import com.sohag.laundry_backend.dto.TransactionDto;
import com.sohag.laundry_backend.service.EmployeeService;
import com.sohag.laundry_backend.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping
    public String addEmployee(@RequestBody TransactionDto dto) {
        dto = transactionService.doSave(dto);
        return "redirect:/customer";
    }
}