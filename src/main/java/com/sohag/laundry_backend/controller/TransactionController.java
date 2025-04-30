package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.TransactionDto;
import com.sohag.laundry_backend.exception.NotFoundException;
import com.sohag.laundry_backend.model.Transaction;
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

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public String transaction(Model model) {
        List<Transaction> list = transactionService.findAll();
        model.addAttribute("transactions", list);
        return "views/transaction";
    }

    @PostMapping("/add")
    public String addOrder(@RequestBody TransactionDto dto) {
        transactionService.doSave(dto);
        return "redirect:/customer";
    }

    @PostMapping("/update")
    public String editOrder(@RequestBody TransactionDto dto) throws NotFoundException {
        transactionService.update(dto);
        return "redirect:/customer";
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
            Transaction transaction = transactionService.findById(trxId);
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
    public ResponseEntity<List<Transaction>> reportData(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date from, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Date to) {
        List<Transaction> list = transactionService.findAllByDateRange(from, to);
        return ResponseEntity.ok(list);
    }
}