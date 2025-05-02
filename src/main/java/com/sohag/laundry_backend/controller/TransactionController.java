package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.OrderDto;
import com.sohag.laundry_backend.exception.NotFoundException;
import com.sohag.laundry_backend.model.Transaction;
import com.sohag.laundry_backend.service.CustomerService;
import com.sohag.laundry_backend.service.EmployeeService;
import com.sohag.laundry_backend.service.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final EmployeeService employeeService;
    private final CustomerService customerService;

    public TransactionController(TransactionService transactionService, EmployeeService employeeService, CustomerService customerService) {
        this.transactionService = transactionService;
        this.employeeService = employeeService;
        this.customerService = customerService;
    }

    @GetMapping
    public String transaction(Model model) {
        List<OrderDto> list = transactionService.findAll();
        model.addAttribute("transactions", list);
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("customers", customerService.findAll());
        return "views/transaction";
    }

    @PostMapping("/add")
    public String addOrder(Model model, @ModelAttribute OrderDto dto) {
        try {
            transactionService.doSave(dto);
            model.addAttribute("path", "transaction");
            return "views/notifications/insert_success";
        } catch (Exception e) {
            return "views/notifications/insert_failed";
        }
    }

    @PostMapping("/update")
    public String editOrder(Model model, @RequestBody OrderDto dto) {
        try {
            transactionService.update(dto);
            model.addAttribute("path", "transaction");
            return "views/notifications/insert_success";
        } catch (NotFoundException e) {
            return "views/notifications/insert_failed";
        }
    }

    @GetMapping("/deliver/{trxId}")
    public String done(Model model, @PathVariable String trxId) {
        try {
            Transaction transaction = transactionService.update(trxId);
            model.addAttribute("path", "transaction");
            model.addAttribute("transaction", transaction);
            return "views/notifications/insert_success";
        } catch (NotFoundException e) {
            return "views/notifications/insert_failed";
        }
    }

    @GetMapping("/print-note/{trxId}")
    public String printNote(Model model, @PathVariable String trxId) {
        try {
            OrderDto transaction = transactionService.findOneById(trxId);
            model.addAttribute("path", "transaction");
            model.addAttribute("trans", transaction);
            return "views/print/print-note";
        } catch (NotFoundException e) {
            model.addAttribute("error", e.getMessage());
            return "views/errors/error_general";
        }
    }

    @GetMapping("/report-filter")
    public String reportFilter() {
        return "views/report/report_filter_transaction";
    }

    @PostMapping("/report-filter")
    @ResponseBody
    public ResponseEntity<List<OrderDto>> reportData(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date from, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Date to) {
        List<OrderDto> list = transactionService.findAllByDateRange(from, to);
        return ResponseEntity.ok(list);
    }
}